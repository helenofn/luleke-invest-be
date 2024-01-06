package br.com.luleke.investbe.request.dto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.luleke.investbe.exception.WalletNotFoundException;
import br.com.luleke.investbe.model.User;
import br.com.luleke.investbe.model.Wallet;
import br.com.luleke.investbe.model.respository.WalletRepository;
import br.com.luleke.investbe.service.wallet.WalletSingleRecordService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WalletDeleteService {

	private final WalletRepository walletRepository;
	private final WalletSingleRecordService walletSingleRecordService;
	
	@Transactional
	public void delete (User user, Long id) {
		//TODO build rule to check if there are transactions in the wallet, if there are then throw an exception
		Wallet wallet = walletSingleRecordService.findByIdFetch(user, id);
		if (null == wallet) {
			throw new WalletNotFoundException();
		}
		this.walletRepository.delete(wallet);
	}
}
