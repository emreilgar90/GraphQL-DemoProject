package com.emreilgar.graphqldemoproject.controller;

import com.emreilgar.graphqldemoproject.model.Address;
import com.emreilgar.graphqldemoproject.model.Contact;
import com.emreilgar.graphqldemoproject.model.Merchant;
import com.emreilgar.graphqldemoproject.repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import javax.management.RuntimeErrorException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MerchantController {
    private final MerchantRepository merchantRepository;
    @MutationMapping
    public Merchant createMerchant(@Argument("merchant") Merchant merchant){
        return merchantRepository.save(merchant);
    }
    @QueryMapping
    public List<Merchant> getMerchants(){
        return merchantRepository.findAll();
    }
    @QueryMapping
    public Merchant getMerchantsById(@Argument("id") Integer id){
        return merchantRepository.findById(id).orElseThrow(()-> new RuntimeException("Merhanct not found with id:"+id));
    }
    @SchemaMapping
    public List<Contact> contacts(Merchant merchant){
        return merchant.getContacts();
    }
    @SchemaMapping
    public Address address(Merchant merchant){
        return merchant.getAddress();
    }
}
