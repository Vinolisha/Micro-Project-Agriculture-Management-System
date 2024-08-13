package com.fullstack.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
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

import com.fullstack.model.FarmerProduct;
import com.fullstack.service.FarmerProductService;


@RestController
@CrossOrigin("*")
@RequestMapping("/FarmerProduct")
public class FarmerProductController {
	
	@Autowired
	FarmerProductService service;
	
	@PostMapping(path="/insertFarmerProduct",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> insertProduct(@RequestParam ("productName") String productName,
		@RequestParam("imageProduct") MultipartFile file,
        @RequestParam("description") String description,
        @RequestParam("price") int price,
        @RequestParam("category") String category,
        @RequestParam("quantity") String quantity) throws IOException {

		FarmerProduct img = new FarmerProduct();
    img.setProductName(productName);
    img.setDescription(description);
    img.setQuantity(quantity);
    img.setPrice(price);
    img.setCategory(category);
    img.setImageName(file.getOriginalFilename());
    img.setImageType(file.getContentType());
    img.setImageProduct(Base64.getEncoder().encode(file.getBytes()));

    try {
        service.insertProduct(img);
        return ResponseEntity.ok("details updated successfully");
    } catch (Exception e) {
        return ResponseEntity.badRequest().body("Deletion Failure");
    }
	}
	
	@GetMapping("/findProdImage/{id}")
	public ResponseEntity<ByteArrayResource> find(@PathVariable ("id") Long productId) {
		try {
			FarmerProduct fur = service.findProductyById(productId);
			byte[] imageProduct = Base64.getDecoder().decode(fur.getImageProduct());
			return ResponseEntity.ok().contentType(MediaType.parseMediaType(fur.getImageType()))
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment: filename=\"" + fur.getImageName() + "\"")
					.body(new ByteArrayResource(imageProduct));
		} catch (Exception e) {
			return null;
		}
	}
	
	@PostMapping("/updateFarmerProduct")
	public ResponseEntity<String> updateProduct(@RequestBody FarmerProduct farProduct){
		try{
			service.updateProduct(farProduct);
			return ResponseEntity.ok("product updated successfully");
		}catch(Exception e){
			return ResponseEntity.badRequest().body("Updation Failure");
		}
		
	}
	
	@DeleteMapping("/deleteProduct/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productId")Long productId){
		try {
			service.deleteProduct(productId);
			return ResponseEntity.ok("Deletion Success");
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Deletion Failure");
		}
	}
	
		@GetMapping("/findProductById/{productId}")
		public FarmerProduct doFindByFarmerProduct(@PathVariable("productId")Long productId) {
			return service.findProductyById(productId);
		}

	@GetMapping("/findAllProduct")
	public List<FarmerProduct> findAllProduct() {
		return service.findAllProduct();
	}
	

	
}
