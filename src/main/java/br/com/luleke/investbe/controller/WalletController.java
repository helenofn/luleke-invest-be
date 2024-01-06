package br.com.luleke.investbe.controller;

import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.luleke.investbe.model.User;
import br.com.luleke.investbe.model.Wallet;
import br.com.luleke.investbe.request.dto.WalletCreateRequestDTO;
import br.com.luleke.investbe.response.dto.WalletListItemResponseDTO;
import br.com.luleke.investbe.response.dto.WalletListResponseDTO;
import br.com.luleke.investbe.service.wallet.WalletCreateService;
import br.com.luleke.investbe.service.wallet.WalletListingService;
import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequestMapping(value = "/v1/wallets")
@RequiredArgsConstructor
public class WalletController {

	private final WalletListingService walletListingService;
	private final WalletCreateService walletCreateService;
	
	@PreAuthorize("hasRole('COMMON')")
	@PostMapping
	public ResponseEntity<Void> create(
			@AuthenticationPrincipal User user,
			@RequestBody WalletCreateRequestDTO request){
		Wallet wallet = walletCreateService.execute(user, request.getName());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(wallet.getSeqId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasRole('COMMON')")
	@GetMapping("/page")
	public ResponseEntity<WalletListResponseDTO> listPage(
			@AuthenticationPrincipal User user,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "15") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
			@RequestParam(value = "seqId", required=false) Long seqId,
			@RequestParam(value = "name", required=false) String name){
		
		Page<Wallet> listModel = walletListingService.listPage(user, page, linesPerPage, direction, orderBy, seqId, name);
		Page<WalletListItemResponseDTO> listDto = listModel.map(obj -> new WalletListItemResponseDTO(obj));
		WalletListResponseDTO listResponse = new WalletListResponseDTO();
		listResponse.setWallets(listDto);
		return ResponseEntity.ok().body(listResponse);
	}
}
