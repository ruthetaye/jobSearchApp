package miu.edu.cs544.ruth.jobsearch.jms;

import miu.edu.cs544.ruth.jobsearch.entity.Job;
import miu.edu.cs544.ruth.jobsearch.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.converter.SimpleMessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Component
public class Sender {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${springjms.mqName}")
    private String queueName;

    @Autowired
    JobRepository jobRepository;

    private final SimpleMessageConverter converter = new SimpleMessageConverter();

    public Job sendJob(Job job)  {
        Job savedJob = null;

        jmsTemplate.setReceiveTimeout(2000);
        MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                Message message = session.createObjectMessage(job);
                message.setJMSCorrelationID(queueName);
                return message;
            }
        };
        Message recieved = jmsTemplate.sendAndReceive(queueName,messageCreator);
        try{
            savedJob = (Job)converter.fromMessage(recieved);
        } catch (JMSException ex){
            System.out.println(ex.getMessage());
        }


        return savedJob;
    }

}
