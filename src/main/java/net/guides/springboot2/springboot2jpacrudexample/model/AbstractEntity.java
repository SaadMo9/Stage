package net.guides.springboot2.springboot2jpacrudexample.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class )
public class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @CreatedDate
    @JsonIgnore
    @Column(name="date de creation"  ,nullable = false)
    private Date creationDate;

    @LastModifiedDate
    @JsonIgnore
    @Column(name="dernier MAJ")
    private Date lastUpdateDate;
}
