package br.com.luleke.investbe.response.dto;

import org.springframework.data.domain.Page;

import br.com.luleke.investbe.dto.WalletDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WalletListResponseDTO extends ReturnDTO{
	
	private Page<WalletDTO> wallets;

}
