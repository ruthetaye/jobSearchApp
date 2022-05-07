package miu.edu.cs544.ruth.jobsearch.controller;

import miu.edu.cs544.ruth.jobsearch.entity.TechnicalInterview;
import miu.edu.cs544.ruth.jobsearch.service.technicalInterview.DeleteTechnicalInterviewService;
import miu.edu.cs544.ruth.jobsearch.service.technicalInterview.GetTechnicalInterviewService;
import miu.edu.cs544.ruth.jobsearch.service.technicalInterview.PostTechnicalInterviewService;
import miu.edu.cs544.ruth.jobsearch.service.technicalInterview.UpdateTechnicalInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs/{id}/technical_interviews")
public class TechnicalInterviewController {
    @Autowired
    GetTechnicalInterviewService getTechnicalInterviewService;
    @Autowired
    PostTechnicalInterviewService postTechnicalInterviewService;
    @Autowired
    DeleteTechnicalInterviewService deleteTechnicalInterviewService;
    @Autowired
    UpdateTechnicalInterviewService updateTechnicalInterviewService;

   @RequestMapping(method = RequestMethod.GET, path = "")
    public List<TechnicalInterview> getAllTechnicalInterviews(@PathVariable("id")long id){
        System.out.println("GetAllTechnicalInterviews");
        return getTechnicalInterviewService.getAllTechnicalInterviews(id);
    }

    @GetMapping("/{technicalInterviewId}")
    public TechnicalInterview getTechnicalInterviewById(@PathVariable("id")long id, @PathVariable("technicalInterviewId") long technicalInterviewId){
        System.out.println("GetScreeningInterviewById");
        return getTechnicalInterviewService.getTechnicalInterviewById(id,technicalInterviewId);
    }

    @PostMapping()
    public TechnicalInterview addTechnicalInterview(@RequestBody TechnicalInterview technicalInterview, @PathVariable("id")long id) {
        return postTechnicalInterviewService.addTechnicalInterview(technicalInterview,id);
    }

    @DeleteMapping("/{technicalInterviewId}")
    public ResponseEntity<String> deleteTechnicalInterview(@PathVariable("id")long id, @PathVariable("technicalInterviewId")long technicalInterviewId){

             return deleteTechnicalInterviewService.deleteTechnicalInterviewById(id,technicalInterviewId);
    }

    @PutMapping("/{technicalInterviewId}")
    public TechnicalInterview updateTechnicalInterview(@PathVariable("id")long id, @PathVariable("technicalInterviewId")long technicalInterviewId, @RequestBody TechnicalInterview technicalInterview) {

             return updateTechnicalInterviewService.updateTechnicalInterview(id,technicalInterviewId,technicalInterview);

    }





}
