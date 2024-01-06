package br.com.luleke.investbe.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.luleke.investbe.model.Wallet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WalletDTO {

	private Long seqId;
	private String name;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dhCreated;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dhLastCalculation;
	
	public WalletDTO(Wallet model) {
		if (null != model) {
			this.seqId = model.getSeqId();
			this.name = model.getName();
			this.dhCreated = model.getDhCreated();
			this.dhLastCalculation = model.getDhLastCalculation();
		}
	}
}
