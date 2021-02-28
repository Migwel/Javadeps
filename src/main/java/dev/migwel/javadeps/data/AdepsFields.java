package dev.migwel.javadeps.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import dev.migwel.javadeps.deserializer.FrenchBooleanDeserializer;
import dev.migwel.javadeps.deserializer.StatusDeserializer;

import java.time.LocalDate;

public record AdepsFields(@JsonProperty("velo") @JsonDeserialize(using = FrenchBooleanDeserializer.class) boolean bike,
                          @JsonProperty("activite") Activity activity,
                          @JsonDeserialize(using = FrenchBooleanDeserializer.class) boolean orientation,
                          @JsonDeserialize(using = FrenchBooleanDeserializer.class) boolean pmr,
                          @JsonProperty("ndeg_pv") String ndegPv,
                          @JsonDeserialize(using = FrenchBooleanDeserializer.class) boolean ravitaillement,
                          String groupement,
                          @JsonProperty("balade_guidee") @JsonDeserialize(using = FrenchBooleanDeserializer.class) boolean guidedWalk,
                          @JsonProperty("entite") String entity,
                          @JsonDeserialize(using = FrenchBooleanDeserializer.class) boolean bewapp,
                          String id,
                          @JsonProperty("15km") @JsonDeserialize(using = FrenchBooleanDeserializer.class) boolean fifteenKm,
                          @JsonDeserialize(using = FrenchBooleanDeserializer.class) boolean vtt,
                          String latitude,
                          String ign,
                          @JsonProperty("localite") String locality,
                          String province,
                          @JsonProperty("nom") String lastName,
                          @JsonProperty("statut") @JsonDeserialize(using = StatusDeserializer.class) Status status,
                          @JsonProperty("lieu_de_rendez_vous") String meetingSpot,
                          @JsonDeserialize(using = FrenchBooleanDeserializer.class) boolean poussettes,
                          @JsonProperty("infos_rendez_vous") String meetingInformation,
                          @JsonDeserialize(using = LocalDateDeserializer.class) LocalDate date,
                          @JsonProperty("prenom") String firstName,
                          double[] geopoint,
                          String longitude,
                          @JsonProperty("10km") @JsonDeserialize(using = FrenchBooleanDeserializer.class) boolean tenKm,
                          @JsonProperty("gsm") String mobilePhoneNumber) {}
