package com.fullstack.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fullstack.model.CropsDetails;
import com.fullstack.model.FarmerProduct;
import com.fullstack.service.CropsDetailsService;
import com.fullstack.service.FarmerProductService;

@RestController
@CrossOrigin("*")
@RequestMapping("/CropsDetails")
public class CropsDetailsController {
	
	@Autowired
	CropsDetailsService service;
	
	@PostMapping(path="/insertCropsDetails",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> upload(@RequestParam("cropsName") String cropsName,
	        @RequestParam("cropsImage") MultipartFile file,
	        @RequestParam("description") String description,
	        @RequestParam("cropsBenefits") String cropsBenefits) throws IOException {

	    CropsDetails img = new CropsDetails();
	    img.setCropsName(cropsName);
	    img.setDescription(description);
	    img.setCropsBenefits(cropsBenefits);
	    img.setImageName(file.getOriginalFilename());
	    img.setImageType(file.getContentType());
	    img.setCropsImage(Base64.getEncoder().encode(file.getBytes()));

	    try {
	        service.insertCropsDetails(img);
	        return ResponseEntity.ok("details updated successfully");
	    } catch (Exception e) {
	        return ResponseEntity.badRequest().body("Deletion Failure");
	    }
	}
			
			
	
//	@PostMapping("/updateCropsDetails")
//	public ResponseEntity<String> updateCropsDetails(@RequestBody CropsDetails details){
//		try{
//			service.updateCropsDetails(details);
//			return ResponseEntity.ok("details updated successfully");
//		}catch(Exception e){
//			return ResponseEntity.badRequest().body("Updation Failure");
//		}
//		
//	}
	
	@DeleteMapping("/deleteCropsDetails/{cropsId}")
	public ResponseEntity<String> deleteCropsDetails(@PathVariable("cropsId")Long cropsId){
		try {
			service.deleteCropsDetails(cropsId);
			return ResponseEntity.ok("Deletion Success");
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Deletion Failure");
		}
	}
	
//		@GetMapping("/findCropsDetailsById/{cropsId}")
//		public CropsDetails findByCropsDetails(@PathVariable("cropsId")Long cropsId) {
//			return service.findCropsDetailsById(cropsId);
//		}

	@GetMapping("/findAllCropsDetails")
	public List<CropsDetails> findAllCropsDetails() {
		return service.findAllCropsDetails();
	}
}
