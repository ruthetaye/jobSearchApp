package miu.edu.cs544.ruth.jobsearch.controller;

import miu.edu.cs544.ruth.jobsearch.entity.ScreeningInterview;
import miu.edu.cs544.ruth.jobsearch.service.screeningInterview.DeleteScreeningInterviewService;
import miu.edu.cs544.ruth.jobsearch.service.screeningInterview.GetScreeningInterviewService;
import miu.edu.cs544.ruth.jobsearch.service.screeningInterview.PostScreeningInterviewService;
import miu.edu.cs544.ruth.jobsearch.service.screeningInterview.UpdateScreeningInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs/{id}/screening_interviews")
public class ScreeningInterviewController {

    @Autowired
    GetScreeningInterviewService getScreeningInterviewService;
    @Autowired
    PostScreeningInterviewService postScreeningInterviewService;
    @Autowired
    DeleteScreeningInterviewService deleteScreeningInterviewService;
    @Autowired
    UpdateScreeningInterviewService updateScreeningInterviewService;

    @GetMapping()
    public List<ScreeningInterview> getAllScreeningInterviews(@PathVariable("id")long id){
        System.out.println("GetAllScreeningInterviews");
        return getScreeningInterviewService.getAllScreeningInterviews(id);
    }

    @GetMapping("/{screeningInterviewId}")
    public ScreeningInterview getScreeningInterviewById(@PathVariable("id")long id, @PathVariable("screeningInterviewId") long screeningInterviewId){
        System.out.println("GetScreeningInterviewById");
        return getScreeningInterviewService.getScreeningInterviewById(id,screeningInterviewId);
    }

    @PostMapping()
    public ScreeningInterview addInterview(@RequestBody ScreeningInterview screeningInterview, @PathVariable("id")long id) {
        return postScreeningInterviewService.addScreeningInterview(screeningInterview,id);
    }

    @DeleteMapping("/{screeningInterviewId}")
    public ResponseEntity<String> deleteScreeningInterview(@PathVariable("id")long id, @PathVariable("screeningInterviewId")long screeningInterviewId){
        return deleteScreeningInterviewService.deleteScreeningInterviewById(id, screeningInterviewId);
    }

    @PutMapping("/{screeningInterviewId}")
    public ScreeningInterview updateScreeningInterview(@PathVariable("id")long id, @PathVariable("screeningInterviewId")long screeningInterviewId, @RequestBody ScreeningInterview screeningInterview) {
        return updateScreeningInterviewService.updateScreeningInterview(id,screeningInterviewId,screeningInterview);

    }





}
