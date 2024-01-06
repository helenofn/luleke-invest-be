package br.com.luleke.investbe.response.dto;

import br.com.luleke.investbe.dto.WalletDTO;
import br.com.luleke.investbe.model.Wallet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WalletResponseDTO extends ReturnDTO{

	private WalletDTO wallet;
	
	public WalletResponseDTO(Wallet wallet) {
		super();
		this.wallet = new WalletDTO(wallet);
	}
}
