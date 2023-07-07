package com.sendbon.domain.documentprocessingrequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(
    name = "DOC_PROCESSING_REQUEST",
    indexes = {
        @Index(name = "IDX_ID_DOC_PROCESSING_REQUEST_ACCOUNT_NUMBER", columnList = "ACCOUNT_NUMBER")
    }
)
@org.hibernate.annotations.BatchSize(size = 20)
public class DocumentProcessingRequest extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "DocumentProcessingRequest_UUID")
    @GenericGenerator(name = "DocumentProcessingRequest_UUID", strategy = "org.hibernate.id.UUIDGenerator", parameters = {
        @org.hibernate.annotations.Parameter(name = "uuid_gen_strategy_class", value = "org.hibernate.id.uuid.CustomVersionOneStrategy")
    })
    @Type(type = "uuid-char")
    @Column(name = "ID", length = 36, nullable = false, updatable = false)
    private UUID id;

    @Version
    @Column(name = "OBJ_VERSION", nullable = false)
    private Integer version;

    @Column(name = "CREATED", nullable = false, updatable = false)
    private LocalDateTime created;

    @Column(name = "UPDATED", nullable = false, updatable = false)
    private LocalDateTime updated;

    @Column(name = "ACCOUNT_NUMBER", nullable = false)
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "ID_DOC_TYPE", nullable = false)
    private IdDocType idDocType;

    @Column(name = "DENIED_REASON")
    private String deniedReason;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private DocumentProcessingStatus status;

    @Column(name = "ID_DOC_EXPIRATION", columnDefinition = "DATE")
    private LocalDate localDate; 
    
    @Lob
    @Column(name="FRONT_SIDE_ID_DOC", columnDefinition="BLOB NOT NULL", nullable = false)
    private byte[] frontSideIdDoc;

    @Lob
    @Column(name="BACK_SIDE_ID_DOC", columnDefinition="BLOB")
    private byte[] backSideIdDoc;

    @Lob
    @Column(name="SELFIE", columnDefinition="BLOB NOT NULL")
    private byte[] selfie;

    @PrePersist
    public void persist() {
        created = LocalDateTime.now(ZoneOffset.UTC);
        updated = LocalDateTime.now(ZoneOffset.UTC);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }


    public String getDeniedReason() {
        return deniedReason;
    }

    public void setDeniedReason(String deniedReason) {
        this.deniedReason = deniedReason;
    }

    public DocumentProcessingStatus getStatus() {
        return status;
    }

    public void setStatus(DocumentProcessingStatus status) {
        this.status = status;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public byte[] getFrontSideIdDoc() {
        return frontSideIdDoc;
    }

    public void setFrontSideIdDoc(byte[] frontSideIdDoc) {
        this.frontSideIdDoc = frontSideIdDoc;
    }

    public byte[] getBackSideIdDoc() {
        return backSideIdDoc;
    }

    public void setBackSideIdDoc(byte[] backSideIdDoc) {
        this.backSideIdDoc = backSideIdDoc;
    }

    public byte[] getSelfie() {
        return selfie;
    }

    public void setSelfie(byte[] selfie) {
        this.selfie = selfie;
    }

    public IdDocType getIdDocType() {
        return idDocType;
    }

    public void setIdDocType(IdDocType idDocType) {
        this.idDocType = idDocType;
    }

    
    

}
