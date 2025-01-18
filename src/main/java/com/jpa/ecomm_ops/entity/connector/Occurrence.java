package com.jpa.ecomm_ops.entity.connector;

import com.safetycube.common.jpa.converter.ListStringConverter;
import com.safetycube.common.jpa.converter.MapStringDateTimeArrayConverter;
import com.safetycube.common.jpa.converter.MapStringDateTimeConverter;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "OCCURRENCE")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Where(clause = "deleted = false")
public class Occurrence implements Serializable {

    @OneToMany(mappedBy = "occurrence", fetch = FetchType.LAZY)
    protected Set<Field> fields = new HashSet<>();

    @OneToMany(mappedBy = "occurrence", fetch = FetchType.LAZY)
    protected List<OccurrenceTags> tags;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(name = "ADDRESSEE")
    private String addressee;
    @Column(name = "AIRCRAFTTYPE")
    private String aircraftType;
    @Column(name = "ANONYMOUS")
    private Boolean anonymous;
    @Column(name = "CITYFROM")
    private String cityFrom;
    @Column(name = "CITYTO")
    private String cityTo;
    @Column(name = "CLOSEDAT")
    private LocalDateTime closedAt;
    @Column(name = "CLOSEDBY")
    private String closedBy;
    @Column(name = "CREATEDAT")
    private LocalDateTime createdAt;
    @Column(name = "CREATEDBY")
    private String createdBy;
    @Column(name = "CUSTOMTYPE")
    private String customType;
    @Column(name = "DATE")
    private LocalDateTime date;
    @OneToMany(mappedBy = "deadlinesIdOwn", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Deadline> deadLines;
    @Column(name = "DELETED")
    private Boolean deleted;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DISCUSSION_ID_OID")
    private Discussion discussion;
    @Column(name = "FIRSTLYNOTIFYAT")
    private LocalDateTime firstlyNotifyAt;
    @Column(name = "FIRSTLYNOTIFYBY")
    private String firstlyNotifyBy;
    @Column(name = "FLIGHTNUMBER")
    private String flightNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FORM_ID_OID")
    private Form form;
    @Column(name = "INTERNALFIELDS")
    private String internalFields;
    @Column(name = "LASTMAILDATE")
    private Integer lastMailDate;
    @Column(name = "LAT")
    private Double lat;
    @Column(name = "LINKED")
    private Long linked;
    @Column(name = "LNG")
    private Double lng;
    @Column(name = "NBSUBOCCURRENCES")
    private Integer nbSubOccurrences;
    @Column(name = "NOTE")
    private String note;
    @Convert(converter = MapStringDateTimeConverter.class)
    @Column(name = "NOTIFICATIONTIME")
    private Map<String, DateTime> notificationTime = new HashMap<>();
    @Convert(converter = MapStringDateTimeArrayConverter.class)
    @Column(name = "NOTIFICATIONTIMES")
    protected Map<String, DateTime[]> notificationTimes = new HashMap<>();
    @Column(name = "NOTIFY")
    private Boolean notify;

    @Column(name = "NOTIFYTO")
    @Convert(converter = ListStringConverter.class)
    private List<String> notifyTo;
    @Column(name = "NOTIFYAT")
    private LocalDateTime notifyAt;
    @Column(name = "NOTIFYBY")
    private String notifyBy;
    @Column(name = "REFERENCE")
    private String reference;
    @Column(name = "REGISTRATIONNUMBER")
    private String registrationNumber;
    @Column(name = "REQUESTEDANSWER")
    private Boolean requestedAnswer;
    @Column(name = "RISKCOUNT")
    private Integer riskCount;
    @Column(name = "SECONDNOTIFYBY")
    private String secondNotifyBy;
    @Column(name = "SECONDLYNOTIFYAT")
    private LocalDateTime secondlyNotifyAt;
    @Column(name = "SITE_ID_OID")
    private Long siteId;

    @MapsId("siteId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SITE_ID_OID", nullable = false)
    private Site site;

    @Column(name = "STATUS")
    private String status;

    @Convert(converter = ListStringConverter.class)
    @Column(name = "STATUSES")
    private List<String> statuses = new ArrayList<>();
    @Column(name = "THIRDLYNOTIFYAT")
    private LocalDateTime thirdlyNotifyAt;
    @Column(name = "THIRDLYNOTIFYBY")
    private String thirdlyNotifyBy;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "TYPENUMBER")
    private Integer typeNumber;
    @Column(name = "VALIDATEDAT")
    private LocalDateTime validatedAt;

    /*    @Column(name = "SUBOCCURRENCES_INTEGER_IDX")
        private Integer subOccurrencesIntegerIdx;*/
    @Column(name = "VALIDATEDBY")
    private String validatedBy;
    @Convert(converter = MapStringDateTimeArrayConverter.class)
    @Column(name = "FIRSTLYNOTIFICATIONTIMES")
    private Map<String, DateTime[]> firstlyNotificationTimes = new HashMap<>();
    @Convert(converter = MapStringDateTimeArrayConverter.class)
    @Column(name = "SECONDLYNOTIFICATIONTIMES")
    private Map<String, DateTime[]> secondlyNotificationTimes = new HashMap<>();
    @Convert(converter = MapStringDateTimeArrayConverter.class)
    @Column(name = "THIRDLYNOTIFICATIONTIMES")
    private Map<String, DateTime[]> thirdlyNotificationTimes = new HashMap<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("subOccurrencesId")
    @JoinColumn(name = "SUBOCCURRENCES_ID_OWN")
    private Occurrence subOccurrencesIdOwn;
    @Column(name = "SUBOCCURRENCES_ID_OWN")
    private Long subOccurrencesId;
    @Column(name = "WORKFLOWSWITCH")
    private Boolean workflowSwitch;
    @Column(name = "UUID")
    private String uuid;

/*    @ManyToOne
    @JoinColumn(name = "OCCURRENCES_ID_OWN")
    private Occurrence occurrencesIdOwn;*/

    /*    @Column(name = "OCCURRENCES_INTEGER_IDX")
        private Integer occurrencesIntegerIdx;*/
    @Column(name = "ISBEINGEDITED")
    private Boolean isBeingEdited;
    @Column(name = "EDITEDBY")
    private String editedBy;
    @Column(name = "MORVOR")
    private Boolean morvor = false;
    @OneToMany(mappedBy = "subOccurrencesIdOwn",fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Occurrence> subOccurrences = new ArrayList<>();
    @OneToMany(mappedBy = "occurrence", fetch = FetchType.LAZY ,  orphanRemoval = true)
    protected List<OccurrenceStatusUpdate> statusUpdates = new ArrayList<>();

    @Convert(converter = MapStringDateTimeConverter.class)
    @Column(name = "ACCESSTIME")
    private Map<String, DateTime> accessTime;

    @OneToMany(mappedBy = "occurrence", fetch = FetchType.LAZY)
    private List<RiskAnalysis> riskAnalyses = new ArrayList<>();

    @OneToMany(mappedBy = "occurrence", fetch = FetchType.LAZY)
    private List<UserOccurrencesshared> userOccurrencesshareds = new ArrayList<>();


    @OneToMany(mappedBy = "masterReport", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Occurrence> linkedReports;

    @OneToMany(mappedBy = "occurrence", fetch = FetchType.LAZY)
    private List<Finding> findings;

    @OneToMany(mappedBy = "occurrence", fetch = FetchType.LAZY)
    private List<Action> actions;

    @OneToMany(mappedBy = "occurrence", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OccurrenceDiffusionSite> diffusionSites;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MASTER_REPORT_ID", nullable = true)
    private Occurrence masterReport; // Null for master reports

    @OneToMany(mappedBy = "occurrence",
            fetch = FetchType.LAZY)
    private List<HistoryOccurrence> histories = new ArrayList<>();

    @OneToMany(mappedBy = "occurrence",fetch = FetchType.LAZY, orphanRemoval = true)
    private List<FolderOccurrence> folders = new ArrayList<>();

}
