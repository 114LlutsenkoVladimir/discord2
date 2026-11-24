package org.example.discord2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MessageAttachmentId implements Serializable {
    private static final long serialVersionUID = -3822680397196731702L;
    @Column(name = "message_id", nullable = false)
    private Long messageId;

    @Column(name = "attachment_id", nullable = false)
    private Long attachmentId;

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Long getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Long attachmentId) {
        this.attachmentId = attachmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MessageAttachmentId entity = (MessageAttachmentId) o;
        return Objects.equals(this.messageId, entity.messageId) &&
                Objects.equals(this.attachmentId, entity.attachmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, attachmentId);
    }

}