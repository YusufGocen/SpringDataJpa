package com.YusufGocen.Dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {
	//Bu sayfada Bütün Verileri Koymamız gerekiyor diger sayfada get post işlemi yapmak istedigimz degerleri koyuyoruz.
	
	
	@NotEmpty(message = "Firstname alanı boş bırakılamaz!")
	@Min(value = 3 , message = "Firstname minumum 3 karakter olmalıdır")
	@Max(value = 10 , message = "Firstname alanı maxiumum 10 karakter olmalıdır.")
	private String isim;
	
	@NotEmpty(message = "LastName Alanı boş olamaz")
	@Min(value = 2,message = "LastName minimum 2 karakter olmalıdır")
	@Max(value = 20,message = "LastName alanı maximum 20 karakter olmalıdır")
	private String soyisim;
}
