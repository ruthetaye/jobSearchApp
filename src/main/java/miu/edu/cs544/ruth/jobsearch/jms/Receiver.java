package miu.edu.cs544.ruth.jobsearch.jms;

import miu.edu.cs544.ruth.jobsearch.entity.Job;
import miu.edu.cs544.ruth.jobsearch.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.converter.SimpleMessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Component
public class Receiver {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${springjms.mqName}")
    private String queueName;

    @Autowired
    JobRepository jobRepository;

    private final SimpleMessageConverter converter = new SimpleMessageConverter();

    @JmsListener(destination = "${springjms.mqName}")
    public void recieve(final Message message) throws Exception {

        Job jobSaved = jobRepository.save((Job)this.converter.fromMessage(message));

        MessageCreator messageCreator = new MessageCreator() {

            @Override
            public Message createMessage(Session session) throws JMSException {
                Message responseMessage = session.createObjectMessage(jobSaved);
                responseMessage.setJMSCorrelationID(message.getJMSCorrelationID());
                return session.createObjectMessage(jobSaved);
            }
        };
        jmsTemplate.send(message.getJMSReplyTo(),messageCreator);

    }

}
