package org.example.discord2.repository;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.example.discord2.entity.Channel;
import org.example.discord2.entity.Message;
import org.example.discord2.entity.User;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Instant;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    @Query("select m from Message m where m.sender.id = ?1")
    List<Message> findBySender_Id(Long id);

    @Query("select ma from MessageAttachment ma " +
            "where (:senderIds IS NULL OR ma.message.sender.id in :senderIds)" +
            "AND (:chanelIds IS NULL OR ma.message.channel.id in :chanelIds)" +
            "AND (:dataTypes IS NULL OR ma.attachment.dataType.id in :dataTypes)")
    List<Message> findByMessageAttachmentCharacteristics(Long id);
}