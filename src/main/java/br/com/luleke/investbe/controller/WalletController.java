package br.com.luleke.investbe.controller;

import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.luleke.investbe.dto.WalletDTO;
import br.com.luleke.investbe.model.User;
import br.com.luleke.investbe.model.Wallet;
import br.com.luleke.investbe.request.dto.WalletCreateRequestDTO;
import br.com.luleke.investbe.request.dto.WalletDeleteService;
import br.com.luleke.investbe.request.dto.WalletUpdateRequestDTO;
import br.com.luleke.investbe.response.dto.WalletListResponseDTO;
import br.com.luleke.investbe.response.dto.WalletResponseDTO;
import br.com.luleke.investbe.service.wallet.WalletCreateService;
import br.com.luleke.investbe.service.wallet.WalletListingService;
import br.com.luleke.investbe.service.wallet.WalletSingleRecordService;
import br.com.luleke.investbe.service.wallet.WalletUpdateService;
import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequestMapping(value = "/v1/wallets")
@RequiredArgsConstructor
public class WalletController {

	private final WalletListingService walletListingService;
	private final WalletCreateService walletCreateService;
	private final WalletSingleRecordService walletSingleRecordService;
	private final WalletUpdateService walletUpdateService;
	private final WalletDeleteService walletDeleteService;
	
	@PreAuthorize("hasRole('COMMON')")
	@PostMapping
	public ResponseEntity<Void> create(
			@AuthenticationPrincipal User user,
			@RequestBody WalletCreateRequestDTO request){
		Wallet wallet = walletCreateService.create(user, request.getName());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(wallet.getSeqId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasRole('COMMON')")
	@PutMapping("/{id}")
	public ResponseEntity<WalletResponseDTO> update(
			@AuthenticationPrincipal User user,
			@PathVariable(value = "id") Long id,
			@RequestBody WalletUpdateRequestDTO request){
		
		Wallet wallet = walletUpdateService.update(user, id, request.getName(), null);
		return ResponseEntity.ok().body(new WalletResponseDTO(wallet));
	}
	
	@PreAuthorize("hasRole('COMMON')")
	@DeleteMapping("/{id}")
	public ResponseEntity<WalletResponseDTO> delete(
			@AuthenticationPrincipal User user,
			@PathVariable(value = "id") Long id){
		
		walletDeleteService.delete(user, id);
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasRole('COMMON')")
	@GetMapping("/{id}")
	public ResponseEntity<WalletResponseDTO> getWallet(
			@AuthenticationPrincipal User user,
			@PathVariable(value = "id") Long id){
		
		Wallet wallet = walletSingleRecordService.findByIdFetch(user, id);
		return ResponseEntity.ok().body(new WalletResponseDTO(wallet));
	}
	
	@PreAuthorize("hasRole('COMMON')")
	@GetMapping
	public ResponseEntity<WalletListResponseDTO> getWallets(
			@AuthenticationPrincipal User user,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "15") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
			@RequestParam(value = "seqId", required=false) Long seqId,
			@RequestParam(value = "name", required=false) String name){
		
		Page<Wallet> listModel = walletListingService.listPage(user, page, linesPerPage, direction, orderBy, seqId, name);
		Page<WalletDTO> listDto = listModel.map(obj -> new WalletDTO(obj));
		WalletListResponseDTO listResponse = new WalletListResponseDTO();
		listResponse.setWallets(listDto);
		return ResponseEntity.ok().body(listResponse);
	}
}
