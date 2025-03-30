package org.delivery.db.account;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.delivery.db.BaseEntity;

@NoArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name = "account")
public class AccountEntity extends BaseEntity {



}
