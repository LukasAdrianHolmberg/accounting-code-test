package com.cubeia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cubeia.model.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {


}
