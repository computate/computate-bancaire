package org.computate.bancaire.frfr.requete.patch;

import org.computate.bancaire.frfr.requete.patch.RequetePatch;
import java.util.Date;
import java.time.ZonedDateTime;
import java.time.LocalDateTime;
import org.apache.commons.lang3.StringUtils;
import java.lang.Integer;
import org.computate.bancaire.frfr.requete.RequeteSiteFrFR;
import java.text.NumberFormat;
import java.lang.Long;
import java.util.Locale;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.lang.Boolean;
import org.computate.bancaire.frfr.ecrivain.ToutEcrivain;
import java.time.ZoneOffset;
import java.lang.String;
import org.computate.bancaire.frfr.cluster.Cluster;
import java.math.MathContext;
import org.apache.commons.text.StringEscapeUtils;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Objects;
import io.vertx.core.json.JsonArray;
import java.util.List;
import java.time.temporal.ChronoUnit;
import org.computate.bancaire.frfr.couverture.Couverture;
import java.time.format.DateTimeFormatter;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import java.lang.Object;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.requete.patch.RequetePatch&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class RequetePatchGen<DEV> extends Object {

	//////////////////
	// requeteSite_ //
	//////////////////

	/**	L'entité « requeteSite_ »
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	protected RequeteSiteFrFR requeteSite_;
	@JsonIgnore
	public Couverture<RequeteSiteFrFR> requeteSite_Couverture = new Couverture<RequeteSiteFrFR>().p(this).c(RequeteSiteFrFR.class).var("requeteSite_").o(requeteSite_);

	/**	<br/>L'entité « requeteSite_ »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.requete.patch.RequetePatch&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:requeteSite_">Trouver l'entité requeteSite_ dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _requeteSite_(Couverture<RequeteSiteFrFR> c);

	public RequeteSiteFrFR getRequeteSite_() {
		return requeteSite_;
	}

	public void setRequeteSite_(RequeteSiteFrFR requeteSite_) {
		this.requeteSite_ = requeteSite_;
		this.requeteSite_Couverture.dejaInitialise = true;
	}
	protected RequetePatch requeteSite_Init() {
		if(!requeteSite_Couverture.dejaInitialise) {
			_requeteSite_(requeteSite_Couverture);
			if(requeteSite_ == null)
				setRequeteSite_(requeteSite_Couverture.o);
		}
		requeteSite_Couverture.dejaInitialise(true);
		return (RequetePatch)this;
	}

	//////////
	// cree //
	//////////

	/**	L'entité « cree »
	 *	 is defined as null before being initialized. 
	 */
	protected ZonedDateTime cree;
	@JsonIgnore
	public Couverture<ZonedDateTime> creeCouverture = new Couverture<ZonedDateTime>().p(this).c(ZonedDateTime.class).var("cree").o(cree);

	/**	<br/>L'entité « cree »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.requete.patch.RequetePatch&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:cree">Trouver l'entité cree dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _cree(Couverture<ZonedDateTime> c);

	public ZonedDateTime getCree() {
		return cree;
	}

	public void setCree(ZonedDateTime cree) {
		this.cree = cree;
		this.creeCouverture.dejaInitialise = true;
	}
	public RequetePatch setCree(Instant o) {
		this.cree = ZonedDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
		this.creeCouverture.dejaInitialise = true;
		return (RequetePatch)this;
	}
	/** Example: 2011-12-03T10:15:30+01:00 **/
	public RequetePatch setCree(String o) {
		this.cree = ZonedDateTime.parse(o, DateTimeFormatter.ISO_OFFSET_DATE_TIME.withZone(ZoneId.of(requeteSite_.getConfigSite_().getSiteZone()))).truncatedTo(ChronoUnit.MILLIS);
		this.creeCouverture.dejaInitialise = true;
		return (RequetePatch)this;
	}
	public RequetePatch setCree(Date o) {
		this.cree = ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(requeteSite_.getConfigSite_().getSiteZone())).truncatedTo(ChronoUnit.MILLIS);
		this.creeCouverture.dejaInitialise = true;
		return (RequetePatch)this;
	}
	protected RequetePatch creeInit() {
		if(!creeCouverture.dejaInitialise) {
			_cree(creeCouverture);
			if(cree == null)
				setCree(creeCouverture.o);
		}
		creeCouverture.dejaInitialise(true);
		return (RequetePatch)this;
	}

	public Date solrCree() {
		return cree == null ? null : Date.from(cree.toInstant());
	}

	public String strCree() {
		return cree == null ? "" : cree.format(DateTimeFormatter.ofPattern("EEE d MMM yyyy H'h'mm:ss zz", Locale.FRANCE));
	}

	public String jsonCree() {
		return cree == null ? "" : cree.format(DateTimeFormatter.ofPattern("EEE d MMM yyyy H'h'mm:ss.SSS zz VV", Locale.FRANCE));
	}

	public String nomAffichageCree() {
		return "crée";
	}

	public String htmTooltipCree() {
		return null;
	}

	public String htmCree() {
		return cree == null ? "" : StringEscapeUtils.escapeHtml4(strCree());
	}

	//////////
	// rows //
	//////////

	/**	L'entité « rows »
	 *	 is defined as null before being initialized. 
	 */
	protected Integer rows;
	@JsonIgnore
	public Couverture<Integer> rowsCouverture = new Couverture<Integer>().p(this).c(Integer.class).var("rows").o(rows);

	/**	<br/>L'entité « rows »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.requete.patch.RequetePatch&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:rows">Trouver l'entité rows dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _rows(Couverture<Integer> c);

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
		this.rowsCouverture.dejaInitialise = true;
	}
	public RequetePatch setRows(String o) {
		if(NumberUtils.isParsable(o))
			this.rows = Integer.parseInt(o);
		this.rowsCouverture.dejaInitialise = true;
		return (RequetePatch)this;
	}
	protected RequetePatch rowsInit() {
		if(!rowsCouverture.dejaInitialise) {
			_rows(rowsCouverture);
			if(rows == null)
				setRows(rowsCouverture.o);
		}
		rowsCouverture.dejaInitialise(true);
		return (RequetePatch)this;
	}

	public Integer solrRows() {
		return rows;
	}

	public String strRows() {
		return rows == null ? "" : rows.toString();
	}

	public String jsonRows() {
		return rows == null ? "" : rows.toString();
	}

	public String nomAffichageRows() {
		return null;
	}

	public String htmTooltipRows() {
		return null;
	}

	public String htmRows() {
		return rows == null ? "" : StringEscapeUtils.escapeHtml4(strRows());
	}

	//////////////
	// numFound //
	//////////////

	/**	L'entité « numFound »
	 *	 is defined as null before being initialized. 
	 */
	protected Long numFound;
	@JsonIgnore
	public Couverture<Long> numFoundCouverture = new Couverture<Long>().p(this).c(Long.class).var("numFound").o(numFound);

	/**	<br/>L'entité « numFound »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.requete.patch.RequetePatch&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:numFound">Trouver l'entité numFound dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _numFound(Couverture<Long> c);

	public Long getNumFound() {
		return numFound;
	}

	public void setNumFound(Long numFound) {
		this.numFound = numFound;
		this.numFoundCouverture.dejaInitialise = true;
	}
	public RequetePatch setNumFound(String o) {
		if(NumberUtils.isParsable(o))
			this.numFound = Long.parseLong(o);
		this.numFoundCouverture.dejaInitialise = true;
		return (RequetePatch)this;
	}
	protected RequetePatch numFoundInit() {
		if(!numFoundCouverture.dejaInitialise) {
			_numFound(numFoundCouverture);
			if(numFound == null)
				setNumFound(numFoundCouverture.o);
		}
		numFoundCouverture.dejaInitialise(true);
		return (RequetePatch)this;
	}

	public Long solrNumFound() {
		return numFound;
	}

	public String strNumFound() {
		return numFound == null ? "" : numFound.toString();
	}

	public String jsonNumFound() {
		return numFound == null ? "" : numFound.toString();
	}

	public String nomAffichageNumFound() {
		return null;
	}

	public String htmTooltipNumFound() {
		return null;
	}

	public String htmNumFound() {
		return numFound == null ? "" : StringEscapeUtils.escapeHtml4(strNumFound());
	}

	//////////////
	// numPATCH //
	//////////////

	/**	L'entité « numPATCH »
	 *	 is defined as null before being initialized. 
	 */
	protected Long numPATCH;
	@JsonIgnore
	public Couverture<Long> numPATCHCouverture = new Couverture<Long>().p(this).c(Long.class).var("numPATCH").o(numPATCH);

	/**	<br/>L'entité « numPATCH »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.requete.patch.RequetePatch&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:numPATCH">Trouver l'entité numPATCH dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _numPATCH(Couverture<Long> c);

	public Long getNumPATCH() {
		return numPATCH;
	}

	public void setNumPATCH(Long numPATCH) {
		this.numPATCH = numPATCH;
		this.numPATCHCouverture.dejaInitialise = true;
	}
	public RequetePatch setNumPATCH(String o) {
		if(NumberUtils.isParsable(o))
			this.numPATCH = Long.parseLong(o);
		this.numPATCHCouverture.dejaInitialise = true;
		return (RequetePatch)this;
	}
	protected RequetePatch numPATCHInit() {
		if(!numPATCHCouverture.dejaInitialise) {
			_numPATCH(numPATCHCouverture);
			if(numPATCH == null)
				setNumPATCH(numPATCHCouverture.o);
		}
		numPATCHCouverture.dejaInitialise(true);
		return (RequetePatch)this;
	}

	public Long solrNumPATCH() {
		return numPATCH;
	}

	public String strNumPATCH() {
		return numPATCH == null ? "" : numPATCH.toString();
	}

	public String jsonNumPATCH() {
		return numPATCH == null ? "" : numPATCH.toString();
	}

	public String nomAffichageNumPATCH() {
		return null;
	}

	public String htmTooltipNumPATCH() {
		return null;
	}

	public String htmNumPATCH() {
		return numPATCH == null ? "" : StringEscapeUtils.escapeHtml4(strNumPATCH());
	}

	//////////
	// uuid //
	//////////

	/**	L'entité « uuid »
	 *	 is defined as null before being initialized. 
	 */
	protected String uuid;
	@JsonIgnore
	public Couverture<String> uuidCouverture = new Couverture<String>().p(this).c(String.class).var("uuid").o(uuid);

	/**	<br/>L'entité « uuid »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.requete.patch.RequetePatch&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:uuid">Trouver l'entité uuid dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _uuid(Couverture<String> c);

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
		this.uuidCouverture.dejaInitialise = true;
	}
	protected RequetePatch uuidInit() {
		if(!uuidCouverture.dejaInitialise) {
			_uuid(uuidCouverture);
			if(uuid == null)
				setUuid(uuidCouverture.o);
		}
		uuidCouverture.dejaInitialise(true);
		return (RequetePatch)this;
	}

	public String solrUuid() {
		return uuid;
	}

	public String strUuid() {
		return uuid == null ? "" : uuid;
	}

	public String jsonUuid() {
		return uuid == null ? "" : uuid;
	}

	public String nomAffichageUuid() {
		return "UUID";
	}

	public String htmTooltipUuid() {
		return null;
	}

	public String htmUuid() {
		return uuid == null ? "" : StringEscapeUtils.escapeHtml4(strUuid());
	}

	////////
	// id //
	////////

	/**	L'entité « id »
	 *	 is defined as null before being initialized. 
	 */
	protected String id;
	@JsonIgnore
	public Couverture<String> idCouverture = new Couverture<String>().p(this).c(String.class).var("id").o(id);

	/**	<br/>L'entité « id »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.requete.patch.RequetePatch&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:id">Trouver l'entité id dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _id(Couverture<String> c);

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
		this.idCouverture.dejaInitialise = true;
	}
	protected RequetePatch idInit() {
		if(!idCouverture.dejaInitialise) {
			_id(idCouverture);
			if(id == null)
				setId(idCouverture.o);
		}
		idCouverture.dejaInitialise(true);
		return (RequetePatch)this;
	}

	public String solrId() {
		return id;
	}

	public String strId() {
		return id == null ? "" : id;
	}

	public String jsonId() {
		return id == null ? "" : id;
	}

	public String nomAffichageId() {
		return null;
	}

	public String htmTooltipId() {
		return null;
	}

	public String htmId() {
		return id == null ? "" : StringEscapeUtils.escapeHtml4(strId());
	}

	///////////
	// empty //
	///////////

	/**	L'entité « empty »
	 *	 is defined as null before being initialized. 
	 */
	protected Boolean empty;
	@JsonIgnore
	public Couverture<Boolean> emptyCouverture = new Couverture<Boolean>().p(this).c(Boolean.class).var("empty").o(empty);

	/**	<br/>L'entité « empty »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.requete.patch.RequetePatch&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:empty">Trouver l'entité empty dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _empty(Couverture<Boolean> c);

	public Boolean getEmpty() {
		return empty;
	}

	public void setEmpty(Boolean empty) {
		this.empty = empty;
		this.emptyCouverture.dejaInitialise = true;
	}
	public RequetePatch setEmpty(String o) {
		this.empty = Boolean.parseBoolean(o);
		this.emptyCouverture.dejaInitialise = true;
		return (RequetePatch)this;
	}
	protected RequetePatch emptyInit() {
		if(!emptyCouverture.dejaInitialise) {
			_empty(emptyCouverture);
			if(empty == null)
				setEmpty(emptyCouverture.o);
		}
		emptyCouverture.dejaInitialise(true);
		return (RequetePatch)this;
	}

	public Boolean solrEmpty() {
		return empty;
	}

	public String strEmpty() {
		return empty == null ? "" : empty.toString();
	}

	public String jsonEmpty() {
		return empty == null ? "" : empty.toString();
	}

	public String nomAffichageEmpty() {
		return null;
	}

	public String htmTooltipEmpty() {
		return null;
	}

	public String htmEmpty() {
		return empty == null ? "" : StringEscapeUtils.escapeHtml4(strEmpty());
	}

	////////
	// pk //
	////////

	/**	L'entité « pk »
	 *	 is defined as null before being initialized. 
	 */
	protected Long pk;
	@JsonIgnore
	public Couverture<Long> pkCouverture = new Couverture<Long>().p(this).c(Long.class).var("pk").o(pk);

	/**	<br/>L'entité « pk »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.requete.patch.RequetePatch&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:pk">Trouver l'entité pk dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _pk(Couverture<Long> c);

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
		this.pkCouverture.dejaInitialise = true;
	}
	public RequetePatch setPk(String o) {
		if(NumberUtils.isParsable(o))
			this.pk = Long.parseLong(o);
		this.pkCouverture.dejaInitialise = true;
		return (RequetePatch)this;
	}
	protected RequetePatch pkInit() {
		if(!pkCouverture.dejaInitialise) {
			_pk(pkCouverture);
			if(pk == null)
				setPk(pkCouverture.o);
		}
		pkCouverture.dejaInitialise(true);
		return (RequetePatch)this;
	}

	public Long solrPk() {
		return pk;
	}

	public String strPk() {
		return pk == null ? "" : pk.toString();
	}

	public String jsonPk() {
		return pk == null ? "" : pk.toString();
	}

	public String nomAffichagePk() {
		return null;
	}

	public String htmTooltipPk() {
		return null;
	}

	public String htmPk() {
		return pk == null ? "" : StringEscapeUtils.escapeHtml4(strPk());
	}

	//////////////
	// original //
	//////////////

	/**	L'entité « original »
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	protected Object original;
	@JsonIgnore
	public Couverture<Object> originalCouverture = new Couverture<Object>().p(this).c(Object.class).var("original").o(original);

	/**	<br/>L'entité « original »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.requete.patch.RequetePatch&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:original">Trouver l'entité original dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _original(Couverture<Object> c);

	public Object getOriginal() {
		return original;
	}

	public void setOriginal(Object original) {
		this.original = original;
		this.originalCouverture.dejaInitialise = true;
	}
	protected RequetePatch originalInit() {
		if(!originalCouverture.dejaInitialise) {
			_original(originalCouverture);
			if(original == null)
				setOriginal(originalCouverture.o);
		}
		originalCouverture.dejaInitialise(true);
		return (RequetePatch)this;
	}

	/////////
	// pks //
	/////////

	/**	L'entité « pks »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut List<Long>(). 
	 */
	protected List<Long> pks = new java.util.ArrayList<java.lang.Long>();
	@JsonIgnore
	public Couverture<List<Long>> pksCouverture = new Couverture<List<Long>>().p(this).c(List.class).var("pks").o(pks);

	/**	<br/>L'entité « pks »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut List<Long>(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.requete.patch.RequetePatch&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:pks">Trouver l'entité pks dans Solr</a>
	 * <br/>
	 * @param pks est l'entité déjà construit. 
	 **/
	protected abstract void _pks(List<Long> c);

	public List<Long> getPks() {
		return pks;
	}

	public void setPks(List<Long> pks) {
		this.pks = pks;
		this.pksCouverture.dejaInitialise = true;
	}
	public RequetePatch addPks(Long...objets) {
		for(Long o : objets) {
			addPks(o);
		}
		return (RequetePatch)this;
	}
	public RequetePatch addPks(Long o) {
		if(o != null && !pks.contains(o))
			this.pks.add(o);
		return (RequetePatch)this;
	}
	public RequetePatch setPks(JsonArray objets) {
		pks.clear();
		for(int i = 0; i < objets.size(); i++) {
			Long o = objets.getLong(i);
			addPks(o);
		}
		return (RequetePatch)this;
	}
	public RequetePatch addPks(String o) {
		if(NumberUtils.isParsable(o)) {
			Long p = Long.parseLong(o);
			addPks(p);
		}
		return (RequetePatch)this;
	}
	protected RequetePatch pksInit() {
		if(!pksCouverture.dejaInitialise) {
			_pks(pks);
		}
		pksCouverture.dejaInitialise(true);
		return (RequetePatch)this;
	}

	public List<Long> solrPks() {
		return pks;
	}

	public String strPks() {
		return pks == null ? "" : pks.toString();
	}

	public String jsonPks() {
		return pks == null ? "" : pks.toString();
	}

	public String nomAffichagePks() {
		return null;
	}

	public String htmTooltipPks() {
		return null;
	}

	public String htmPks() {
		return pks == null ? "" : StringEscapeUtils.escapeHtml4(strPks());
	}

	/////////////
	// classes //
	/////////////

	/**	L'entité « classes »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut List<String>(). 
	 */
	protected List<String> classes = new java.util.ArrayList<java.lang.String>();
	@JsonIgnore
	public Couverture<List<String>> classesCouverture = new Couverture<List<String>>().p(this).c(List.class).var("classes").o(classes);

	/**	<br/>L'entité « classes »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut List<String>(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.requete.patch.RequetePatch&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:classes">Trouver l'entité classes dans Solr</a>
	 * <br/>
	 * @param classes est l'entité déjà construit. 
	 **/
	protected abstract void _classes(List<String> c);

	public List<String> getClasses() {
		return classes;
	}

	public void setClasses(List<String> classes) {
		this.classes = classes;
		this.classesCouverture.dejaInitialise = true;
	}
	public RequetePatch addClasses(String...objets) {
		for(String o : objets) {
			addClasses(o);
		}
		return (RequetePatch)this;
	}
	public RequetePatch addClasses(String o) {
		if(o != null && !classes.contains(o))
			this.classes.add(o);
		return (RequetePatch)this;
	}
	public RequetePatch setClasses(JsonArray objets) {
		classes.clear();
		for(int i = 0; i < objets.size(); i++) {
			String o = objets.getString(i);
			addClasses(o);
		}
		return (RequetePatch)this;
	}
	protected RequetePatch classesInit() {
		if(!classesCouverture.dejaInitialise) {
			_classes(classes);
		}
		classesCouverture.dejaInitialise(true);
		return (RequetePatch)this;
	}

	public List<String> solrClasses() {
		return classes;
	}

	public String strClasses() {
		return classes == null ? "" : classes.toString();
	}

	public String jsonClasses() {
		return classes == null ? "" : classes.toString();
	}

	public String nomAffichageClasses() {
		return null;
	}

	public String htmTooltipClasses() {
		return null;
	}

	public String htmClasses() {
		return classes == null ? "" : StringEscapeUtils.escapeHtml4(strClasses());
	}

	//////////
	// vars //
	//////////

	/**	L'entité « vars »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut List<String>(). 
	 */
	protected List<String> vars = new java.util.ArrayList<java.lang.String>();
	@JsonIgnore
	public Couverture<List<String>> varsCouverture = new Couverture<List<String>>().p(this).c(List.class).var("vars").o(vars);

	/**	<br/>L'entité « vars »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut List<String>(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.requete.patch.RequetePatch&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:vars">Trouver l'entité vars dans Solr</a>
	 * <br/>
	 * @param vars est l'entité déjà construit. 
	 **/
	protected abstract void _vars(List<String> c);

	public List<String> getVars() {
		return vars;
	}

	public void setVars(List<String> vars) {
		this.vars = vars;
		this.varsCouverture.dejaInitialise = true;
	}
	public RequetePatch addVars(String...objets) {
		for(String o : objets) {
			addVars(o);
		}
		return (RequetePatch)this;
	}
	public RequetePatch addVars(String o) {
		if(o != null && !vars.contains(o))
			this.vars.add(o);
		return (RequetePatch)this;
	}
	public RequetePatch setVars(JsonArray objets) {
		vars.clear();
		for(int i = 0; i < objets.size(); i++) {
			String o = objets.getString(i);
			addVars(o);
		}
		return (RequetePatch)this;
	}
	protected RequetePatch varsInit() {
		if(!varsCouverture.dejaInitialise) {
			_vars(vars);
		}
		varsCouverture.dejaInitialise(true);
		return (RequetePatch)this;
	}

	public List<String> solrVars() {
		return vars;
	}

	public String strVars() {
		return vars == null ? "" : vars.toString();
	}

	public String jsonVars() {
		return vars == null ? "" : vars.toString();
	}

	public String nomAffichageVars() {
		return null;
	}

	public String htmTooltipVars() {
		return null;
	}

	public String htmVars() {
		return vars == null ? "" : StringEscapeUtils.escapeHtml4(strVars());
	}

	//////////////
	// initLoin //
	//////////////

	protected boolean dejaInitialiseRequetePatch = false;

	public RequetePatch initLoinRequetePatch(RequeteSiteFrFR requeteSite_) {
		setRequeteSite_(requeteSite_);
		if(!dejaInitialiseRequetePatch) {
			dejaInitialiseRequetePatch = true;
			initLoinRequetePatch();
		}
		return (RequetePatch)this;
	}

	public void initLoinRequetePatch() {
		initRequetePatch();
	}

	public void initRequetePatch() {
		requeteSite_Init();
		creeInit();
		rowsInit();
		numFoundInit();
		numPATCHInit();
		uuidInit();
		idInit();
		emptyInit();
		pkInit();
		originalInit();
		pksInit();
		classesInit();
		varsInit();
	}

	public void initLoinPourClasse(RequeteSiteFrFR requeteSite_) {
		initLoinRequetePatch(requeteSite_);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteRequetePatch(RequeteSiteFrFR requeteSite_) {
	}

	public void requeteSitePourClasse(RequeteSiteFrFR requeteSite_) {
		requeteSiteRequetePatch(requeteSite_);
	}

	/////////////
	// obtenir //
	/////////////

	public Object obtenirPourClasse(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirRequetePatch(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirRequetePatch(String var) {
		RequetePatch oRequetePatch = (RequetePatch)this;
		switch(var) {
			case "requeteSite_":
				return oRequetePatch.requeteSite_;
			case "cree":
				return oRequetePatch.cree;
			case "rows":
				return oRequetePatch.rows;
			case "numFound":
				return oRequetePatch.numFound;
			case "numPATCH":
				return oRequetePatch.numPATCH;
			case "uuid":
				return oRequetePatch.uuid;
			case "id":
				return oRequetePatch.id;
			case "empty":
				return oRequetePatch.empty;
			case "pk":
				return oRequetePatch.pk;
			case "original":
				return oRequetePatch.original;
			case "pks":
				return oRequetePatch.pks;
			case "classes":
				return oRequetePatch.classes;
			case "vars":
				return oRequetePatch.vars;
			default:
				return null;
		}
	}

	///////////////
	// attribuer //
	///////////////

	public boolean attribuerPourClasse(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = attribuerRequetePatch(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerRequetePatch(String var, Object val) {
		RequetePatch oRequetePatch = (RequetePatch)this;
		switch(var) {
			default:
				return null;
		}
	}

	/////////////
	// definir //
	/////////////

	public boolean definirPourClasse(String var, String val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = definirRequetePatch(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirRequetePatch(String var, String val) {
		switch(var) {
			default:
				return null;
		}
	}

	//////////////////
	// requetePatch //
	//////////////////

	public void requetePatchRequetePatch() {
		RequetePatch requetePatch = Optional.ofNullable(requeteSite_).map(RequeteSiteFrFR::getRequetePatch_).orElse(null);
		RequetePatch original = (RequetePatch)Optional.ofNullable(requetePatch).map(RequetePatch::getOriginal).orElse(null);
		if(original != null) {
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash();
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof RequetePatch))
			return false;
		RequetePatch that = (RequetePatch)o;
		return true;
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("RequetePatch { ");
		sb.append(" }");
		return sb.toString();
	}
}
