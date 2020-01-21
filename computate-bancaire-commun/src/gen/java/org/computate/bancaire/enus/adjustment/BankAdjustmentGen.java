package org.computate.bancaire.enus.adjustment;

import org.computate.bancaire.enus.request.patch.PatchRequest;
import java.util.Date;
import java.time.ZonedDateTime;
import java.time.LocalDateTime;
import org.apache.commons.lang3.StringUtils;
import org.computate.bancaire.enus.request.SiteRequestEnUS;
import io.vertx.core.logging.LoggerFactory;
import java.text.NumberFormat;
import org.computate.bancaire.enus.contexte.SiteContextEnUS;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.lang.Long;
import java.util.Locale;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.lang.Boolean;
import io.vertx.core.json.JsonObject;
import org.computate.bancaire.enus.writer.AllWriter;
import java.lang.String;
import java.time.ZoneOffset;
import io.vertx.core.logging.Logger;
import org.computate.bancaire.enus.transaction.BankTransaction;
import org.computate.bancaire.enus.cluster.Cluster;
import java.math.MathContext;
import org.apache.solr.client.solrj.response.QueryResponse;
import java.util.Set;
import org.apache.commons.text.StringEscapeUtils;
import java.time.Instant;
import java.time.ZoneId;
import org.apache.solr.client.solrj.SolrClient;
import java.util.Objects;
import io.vertx.core.json.JsonArray;
import org.apache.solr.common.SolrDocument;
import java.util.List;
import java.time.temporal.ChronoUnit;
import org.computate.bancaire.enus.wrap.Wrap;
import org.computate.bancaire.enus.search.SearchList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import org.apache.solr.client.solrj.SolrQuery;
import io.vertx.ext.sql.SQLConnection;
import org.apache.commons.lang3.math.NumberUtils;
import org.computate.bancaire.enus.account.BankAccount;
import java.util.Optional;
import io.vertx.ext.sql.SQLClient;
import org.apache.solr.client.solrj.util.ClientUtils;
import org.apache.solr.common.SolrInputDocument;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.adjustment.BankAdjustment&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class BankAdjustmentGen<DEV> extends Cluster {
	private static final Logger LOGGER = LoggerFactory.getLogger(BankAdjustment.class);

	public static final String BankAdjustment_UnNom = "an adjustment";
	public static final String BankAdjustment_Ce = "this ";
	public static final String BankAdjustment_CeNom = "this adjustment";
	public static final String BankAdjustment_Un = "a ";
	public static final String BankAdjustment_LeNom = "theadjustment";
	public static final String BankAdjustment_NomSingulier = "adjustment";
	public static final String BankAdjustment_NomPluriel = "adjustments";
	public static final String BankAdjustment_NomActuel = "current adjustment";
	public static final String BankAdjustment_TousNom = "all the adjustments";
	public static final String BankAdjustment_RechercherTousNomPar = "search adjustments by ";
	public static final String BankAdjustment_LesNoms = "the adjustments";
	public static final String BankAdjustment_AucunNomTrouve = "no adjustment found";
	public static final String BankAdjustment_NomVar = "adjustment";
	public static final String BankAdjustment_DeNom = "of adjustment";
	public static final String BankAdjustment_UnNomAdjectif = "an adjustment";
	public static final String BankAdjustment_NomAdjectifSingulier = "adjustment";
	public static final String BankAdjustment_NomAdjectifPluriel = "adjustments";
	public static final String BankAdjustment_Couleur = "yellow";
	public static final String BankAdjustment_IconeGroupe = "duotone";
	public static final String BankAdjustment_IconeNom = "cash-register";

	///////////////////
	// adjustmentKey //
	///////////////////

	/**	L'entité « adjustmentKey »
	 *	 is defined as null before being initialized. 
	 */
	protected Long adjustmentKey;
	@JsonIgnore
	public Wrap<Long> adjustmentKeyWrap = new Wrap<Long>().p(this).c(Long.class).var("adjustmentKey").o(adjustmentKey);

	/**	<br/>L'entité « adjustmentKey »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.adjustment.BankAdjustment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:adjustmentKey">Trouver l'entité adjustmentKey dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _adjustmentKey(Wrap<Long> c);

	public Long getAdjustmentKey() {
		return adjustmentKey;
	}

	public void setAdjustmentKey(Long adjustmentKey) {
		this.adjustmentKey = adjustmentKey;
		this.adjustmentKeyWrap.alreadyInitialized = true;
	}
	public BankAdjustment setAdjustmentKey(String o) {
		if(NumberUtils.isParsable(o))
			this.adjustmentKey = Long.parseLong(o);
		this.adjustmentKeyWrap.alreadyInitialized = true;
		return (BankAdjustment)this;
	}
	protected BankAdjustment adjustmentKeyInit() {
		if(!adjustmentKeyWrap.alreadyInitialized) {
			_adjustmentKey(adjustmentKeyWrap);
			if(adjustmentKey == null)
				setAdjustmentKey(adjustmentKeyWrap.o);
		}
		adjustmentKeyWrap.alreadyInitialized(true);
		return (BankAdjustment)this;
	}

	public Long solrAdjustmentKey() {
		return adjustmentKey;
	}

	public String strAdjustmentKey() {
		return adjustmentKey == null ? "" : adjustmentKey.toString();
	}

	public String jsonAdjustmentKey() {
		return adjustmentKey == null ? "" : adjustmentKey.toString();
	}

	public String nomAffichageAdjustmentKey() {
		return "key";
	}

	public String htmTooltipAdjustmentKey() {
		return null;
	}

	public String htmAdjustmentKey() {
		return adjustmentKey == null ? "" : StringEscapeUtils.escapeHtml4(strAdjustmentKey());
	}

	////////////////
	// accountKey //
	////////////////

	/**	L'entité « accountKey »
	 *	 is defined as null before being initialized. 
	 */
	protected Long accountKey;
	@JsonIgnore
	public Wrap<Long> accountKeyWrap = new Wrap<Long>().p(this).c(Long.class).var("accountKey").o(accountKey);

	/**	<br/>L'entité « accountKey »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.adjustment.BankAdjustment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:accountKey">Trouver l'entité accountKey dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _accountKey(Wrap<Long> c);

	public Long getAccountKey() {
		return accountKey;
	}

	public void setAccountKey(Long accountKey) {
		this.accountKey = accountKey;
		this.accountKeyWrap.alreadyInitialized = true;
	}
	public BankAdjustment setAccountKey(String o) {
		if(NumberUtils.isParsable(o))
			this.accountKey = Long.parseLong(o);
		this.accountKeyWrap.alreadyInitialized = true;
		return (BankAdjustment)this;
	}
	protected BankAdjustment accountKeyInit() {
		if(!accountKeyWrap.alreadyInitialized) {
			_accountKey(accountKeyWrap);
			if(accountKey == null)
				setAccountKey(accountKeyWrap.o);
		}
		accountKeyWrap.alreadyInitialized(true);
		return (BankAdjustment)this;
	}

	public Long solrAccountKey() {
		return accountKey;
	}

	public String strAccountKey() {
		return accountKey == null ? "" : accountKey.toString();
	}

	public String jsonAccountKey() {
		return accountKey == null ? "" : accountKey.toString();
	}

	public String nomAffichageAccountKey() {
		return "account";
	}

	public String htmTooltipAccountKey() {
		return null;
	}

	public String htmAccountKey() {
		return accountKey == null ? "" : StringEscapeUtils.escapeHtml4(strAccountKey());
	}

	public void inputAccountKey(String classApiMethodMethod) {
		BankAdjustment s = (BankAdjustment)this;
	}

	public void htmAccountKey(String classApiMethodMethod) {
		BankAdjustment s = (BankAdjustment)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("class", "").f().sx("account").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").f().sx(strAccountKey()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	///////////////////
	// accountSearch //
	///////////////////

	/**	L'entité « accountSearch »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut SearchList<BankAccount>(). 
	 */
	@JsonIgnore
	protected SearchList<BankAccount> accountSearch = new SearchList<BankAccount>();
	@JsonIgnore
	public Wrap<SearchList<BankAccount>> accountSearchWrap = new Wrap<SearchList<BankAccount>>().p(this).c(SearchList.class).var("accountSearch").o(accountSearch);

	/**	<br/>L'entité « accountSearch »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut SearchList<BankAccount>(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.adjustment.BankAdjustment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:accountSearch">Trouver l'entité accountSearch dans Solr</a>
	 * <br/>
	 * @param accountSearch est l'entité déjà construit. 
	 **/
	protected abstract void _accountSearch(SearchList<BankAccount> l);

	public SearchList<BankAccount> getAccountSearch() {
		return accountSearch;
	}

	public void setAccountSearch(SearchList<BankAccount> accountSearch) {
		this.accountSearch = accountSearch;
		this.accountSearchWrap.alreadyInitialized = true;
	}
	protected BankAdjustment accountSearchInit() {
		if(!accountSearchWrap.alreadyInitialized) {
			_accountSearch(accountSearch);
		}
		accountSearch.initDeepForClass(siteRequest_);
		accountSearchWrap.alreadyInitialized(true);
		return (BankAdjustment)this;
	}

	//////////////
	// account_ //
	//////////////

	/**	L'entité « account_ »
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	protected BankAccount account_;
	@JsonIgnore
	public Wrap<BankAccount> account_Wrap = new Wrap<BankAccount>().p(this).c(BankAccount.class).var("account_").o(account_);

	/**	<br/>L'entité « account_ »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.adjustment.BankAdjustment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:account_">Trouver l'entité account_ dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _account_(Wrap<BankAccount> c);

	public BankAccount getAccount_() {
		return account_;
	}

	public void setAccount_(BankAccount account_) {
		this.account_ = account_;
		this.account_Wrap.alreadyInitialized = true;
	}
	protected BankAdjustment account_Init() {
		if(!account_Wrap.alreadyInitialized) {
			_account_(account_Wrap);
			if(account_ == null)
				setAccount_(account_Wrap.o);
		}
		account_Wrap.alreadyInitialized(true);
		return (BankAdjustment)this;
	}

	/////////////////////////
	// accountCompleteName //
	/////////////////////////

	/**	L'entité « accountCompleteName »
	 *	 is defined as null before being initialized. 
	 */
	protected String accountCompleteName;
	@JsonIgnore
	public Wrap<String> accountCompleteNameWrap = new Wrap<String>().p(this).c(String.class).var("accountCompleteName").o(accountCompleteName);

	/**	<br/>L'entité « accountCompleteName »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.adjustment.BankAdjustment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:accountCompleteName">Trouver l'entité accountCompleteName dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _accountCompleteName(Wrap<String> c);

	public String getAccountCompleteName() {
		return accountCompleteName;
	}

	public void setAccountCompleteName(String accountCompleteName) {
		this.accountCompleteName = accountCompleteName;
		this.accountCompleteNameWrap.alreadyInitialized = true;
	}
	protected BankAdjustment accountCompleteNameInit() {
		if(!accountCompleteNameWrap.alreadyInitialized) {
			_accountCompleteName(accountCompleteNameWrap);
			if(accountCompleteName == null)
				setAccountCompleteName(accountCompleteNameWrap.o);
		}
		accountCompleteNameWrap.alreadyInitialized(true);
		return (BankAdjustment)this;
	}

	public String solrAccountCompleteName() {
		return accountCompleteName;
	}

	public String strAccountCompleteName() {
		return accountCompleteName == null ? "" : accountCompleteName;
	}

	public String jsonAccountCompleteName() {
		return accountCompleteName == null ? "" : accountCompleteName;
	}

	public String nomAffichageAccountCompleteName() {
		return null;
	}

	public String htmTooltipAccountCompleteName() {
		return null;
	}

	public String htmAccountCompleteName() {
		return accountCompleteName == null ? "" : StringEscapeUtils.escapeHtml4(strAccountCompleteName());
	}

	///////////////////
	// accountNumber //
	///////////////////

	/**	L'entité « accountNumber »
	 *	 is defined as null before being initialized. 
	 */
	protected String accountNumber;
	@JsonIgnore
	public Wrap<String> accountNumberWrap = new Wrap<String>().p(this).c(String.class).var("accountNumber").o(accountNumber);

	/**	<br/>L'entité « accountNumber »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.adjustment.BankAdjustment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:accountNumber">Trouver l'entité accountNumber dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _accountNumber(Wrap<String> c);

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
		this.accountNumberWrap.alreadyInitialized = true;
	}
	protected BankAdjustment accountNumberInit() {
		if(!accountNumberWrap.alreadyInitialized) {
			_accountNumber(accountNumberWrap);
			if(accountNumber == null)
				setAccountNumber(accountNumberWrap.o);
		}
		accountNumberWrap.alreadyInitialized(true);
		return (BankAdjustment)this;
	}

	public String solrAccountNumber() {
		return accountNumber;
	}

	public String strAccountNumber() {
		return accountNumber == null ? "" : accountNumber;
	}

	public String jsonAccountNumber() {
		return accountNumber == null ? "" : accountNumber;
	}

	public String nomAffichageAccountNumber() {
		return null;
	}

	public String htmTooltipAccountNumber() {
		return null;
	}

	public String htmAccountNumber() {
		return accountNumber == null ? "" : StringEscapeUtils.escapeHtml4(strAccountNumber());
	}

	////////////////////
	// transactionKey //
	////////////////////

	/**	L'entité « transactionKey »
	 *	 is defined as null before being initialized. 
	 */
	protected Long transactionKey;
	@JsonIgnore
	public Wrap<Long> transactionKeyWrap = new Wrap<Long>().p(this).c(Long.class).var("transactionKey").o(transactionKey);

	/**	<br/>L'entité « transactionKey »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.adjustment.BankAdjustment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:transactionKey">Trouver l'entité transactionKey dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _transactionKey(Wrap<Long> c);

	public Long getTransactionKey() {
		return transactionKey;
	}

	public void setTransactionKey(Long transactionKey) {
		this.transactionKey = transactionKey;
		this.transactionKeyWrap.alreadyInitialized = true;
	}
	public BankAdjustment setTransactionKey(String o) {
		if(NumberUtils.isParsable(o))
			this.transactionKey = Long.parseLong(o);
		this.transactionKeyWrap.alreadyInitialized = true;
		return (BankAdjustment)this;
	}
	protected BankAdjustment transactionKeyInit() {
		if(!transactionKeyWrap.alreadyInitialized) {
			_transactionKey(transactionKeyWrap);
			if(transactionKey == null)
				setTransactionKey(transactionKeyWrap.o);
		}
		transactionKeyWrap.alreadyInitialized(true);
		return (BankAdjustment)this;
	}

	public Long solrTransactionKey() {
		return transactionKey;
	}

	public String strTransactionKey() {
		return transactionKey == null ? "" : transactionKey.toString();
	}

	public String jsonTransactionKey() {
		return transactionKey == null ? "" : transactionKey.toString();
	}

	public String nomAffichageTransactionKey() {
		return "transaction";
	}

	public String htmTooltipTransactionKey() {
		return null;
	}

	public String htmTransactionKey() {
		return transactionKey == null ? "" : StringEscapeUtils.escapeHtml4(strTransactionKey());
	}

	public void inputTransactionKey(String classApiMethodMethod) {
		BankAdjustment s = (BankAdjustment)this;
	}

	public void htmTransactionKey(String classApiMethodMethod) {
		BankAdjustment s = (BankAdjustment)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("class", "").f().sx("transaction").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").f().sx(strTransactionKey()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	///////////////////////
	// transactionSearch //
	///////////////////////

	/**	L'entité « transactionSearch »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut SearchList<BankTransaction>(). 
	 */
	@JsonIgnore
	protected SearchList<BankTransaction> transactionSearch = new SearchList<BankTransaction>();
	@JsonIgnore
	public Wrap<SearchList<BankTransaction>> transactionSearchWrap = new Wrap<SearchList<BankTransaction>>().p(this).c(SearchList.class).var("transactionSearch").o(transactionSearch);

	/**	<br/>L'entité « transactionSearch »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut SearchList<BankTransaction>(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.adjustment.BankAdjustment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:transactionSearch">Trouver l'entité transactionSearch dans Solr</a>
	 * <br/>
	 * @param transactionSearch est l'entité déjà construit. 
	 **/
	protected abstract void _transactionSearch(SearchList<BankTransaction> l);

	public SearchList<BankTransaction> getTransactionSearch() {
		return transactionSearch;
	}

	public void setTransactionSearch(SearchList<BankTransaction> transactionSearch) {
		this.transactionSearch = transactionSearch;
		this.transactionSearchWrap.alreadyInitialized = true;
	}
	protected BankAdjustment transactionSearchInit() {
		if(!transactionSearchWrap.alreadyInitialized) {
			_transactionSearch(transactionSearch);
		}
		transactionSearch.initDeepForClass(siteRequest_);
		transactionSearchWrap.alreadyInitialized(true);
		return (BankAdjustment)this;
	}

	//////////////////
	// transaction_ //
	//////////////////

	/**	L'entité « transaction_ »
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	protected BankTransaction transaction_;
	@JsonIgnore
	public Wrap<BankTransaction> transaction_Wrap = new Wrap<BankTransaction>().p(this).c(BankTransaction.class).var("transaction_").o(transaction_);

	/**	<br/>L'entité « transaction_ »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.adjustment.BankAdjustment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:transaction_">Trouver l'entité transaction_ dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _transaction_(Wrap<BankTransaction> c);

	public BankTransaction getTransaction_() {
		return transaction_;
	}

	public void setTransaction_(BankTransaction transaction_) {
		this.transaction_ = transaction_;
		this.transaction_Wrap.alreadyInitialized = true;
	}
	protected BankAdjustment transaction_Init() {
		if(!transaction_Wrap.alreadyInitialized) {
			_transaction_(transaction_Wrap);
			if(transaction_ == null)
				setTransaction_(transaction_Wrap.o);
		}
		transaction_Wrap.alreadyInitialized(true);
		return (BankAdjustment)this;
	}

	////////////////////////////
	// transactionReferenceId //
	////////////////////////////

	/**	L'entité « transactionReferenceId »
	 *	 is defined as null before being initialized. 
	 */
	protected String transactionReferenceId;
	@JsonIgnore
	public Wrap<String> transactionReferenceIdWrap = new Wrap<String>().p(this).c(String.class).var("transactionReferenceId").o(transactionReferenceId);

	/**	<br/>L'entité « transactionReferenceId »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.adjustment.BankAdjustment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:transactionReferenceId">Trouver l'entité transactionReferenceId dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _transactionReferenceId(Wrap<String> c);

	public String getTransactionReferenceId() {
		return transactionReferenceId;
	}

	public void setTransactionReferenceId(String transactionReferenceId) {
		this.transactionReferenceId = transactionReferenceId;
		this.transactionReferenceIdWrap.alreadyInitialized = true;
	}
	protected BankAdjustment transactionReferenceIdInit() {
		if(!transactionReferenceIdWrap.alreadyInitialized) {
			_transactionReferenceId(transactionReferenceIdWrap);
			if(transactionReferenceId == null)
				setTransactionReferenceId(transactionReferenceIdWrap.o);
		}
		transactionReferenceIdWrap.alreadyInitialized(true);
		return (BankAdjustment)this;
	}

	public String solrTransactionReferenceId() {
		return transactionReferenceId;
	}

	public String strTransactionReferenceId() {
		return transactionReferenceId == null ? "" : transactionReferenceId;
	}

	public String jsonTransactionReferenceId() {
		return transactionReferenceId == null ? "" : transactionReferenceId;
	}

	public String nomAffichageTransactionReferenceId() {
		return "transaction reference ID";
	}

	public String htmTooltipTransactionReferenceId() {
		return null;
	}

	public String htmTransactionReferenceId() {
		return transactionReferenceId == null ? "" : StringEscapeUtils.escapeHtml4(strTransactionReferenceId());
	}

	/////////////////////
	// transactionCode //
	/////////////////////

	/**	L'entité « transactionCode »
	 *	 is defined as null before being initialized. 
	 */
	protected String transactionCode;
	@JsonIgnore
	public Wrap<String> transactionCodeWrap = new Wrap<String>().p(this).c(String.class).var("transactionCode").o(transactionCode);

	/**	<br/>L'entité « transactionCode »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.adjustment.BankAdjustment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:transactionCode">Trouver l'entité transactionCode dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _transactionCode(Wrap<String> c);

	public String getTransactionCode() {
		return transactionCode;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
		this.transactionCodeWrap.alreadyInitialized = true;
	}
	protected BankAdjustment transactionCodeInit() {
		if(!transactionCodeWrap.alreadyInitialized) {
			_transactionCode(transactionCodeWrap);
			if(transactionCode == null)
				setTransactionCode(transactionCodeWrap.o);
		}
		transactionCodeWrap.alreadyInitialized(true);
		return (BankAdjustment)this;
	}

	public String solrTransactionCode() {
		return transactionCode;
	}

	public String strTransactionCode() {
		return transactionCode == null ? "" : transactionCode;
	}

	public String jsonTransactionCode() {
		return transactionCode == null ? "" : transactionCode;
	}

	public String nomAffichageTransactionCode() {
		return null;
	}

	public String htmTooltipTransactionCode() {
		return null;
	}

	public String htmTransactionCode() {
		return transactionCode == null ? "" : StringEscapeUtils.escapeHtml4(strTransactionCode());
	}

	///////////////////////
	// transactionAmount //
	///////////////////////

	/**	L'entité « transactionAmount »
	 *	 is defined as null before being initialized. 
	 */
	protected BigDecimal transactionAmount;
	@JsonIgnore
	public Wrap<BigDecimal> transactionAmountWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("transactionAmount").o(transactionAmount);

	/**	<br/>L'entité « transactionAmount »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.adjustment.BankAdjustment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:transactionAmount">Trouver l'entité transactionAmount dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _transactionAmount(Wrap<BigDecimal> c);

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
		this.transactionAmountWrap.alreadyInitialized = true;
	}
	public BankAdjustment setTransactionAmount(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.transactionAmount = new BigDecimal(o, MathContext.DECIMAL64).setScale(2);
		this.transactionAmountWrap.alreadyInitialized = true;
		return (BankAdjustment)this;
	}
	public BankAdjustment setTransactionAmount(Double o) {
			this.transactionAmount = new BigDecimal(o, MathContext.DECIMAL64).setScale(2);
		this.transactionAmountWrap.alreadyInitialized = true;
		return (BankAdjustment)this;
	}
	public BankAdjustment setTransactionAmount(Integer o) {
			this.transactionAmount = new BigDecimal(o, MathContext.DECIMAL64).setScale(2);
		this.transactionAmountWrap.alreadyInitialized = true;
		return (BankAdjustment)this;
	}
	protected BankAdjustment transactionAmountInit() {
		if(!transactionAmountWrap.alreadyInitialized) {
			_transactionAmount(transactionAmountWrap);
			if(transactionAmount == null)
				setTransactionAmount(transactionAmountWrap.o);
		}
		transactionAmountWrap.alreadyInitialized(true);
		return (BankAdjustment)this;
	}

	public Double solrTransactionAmount() {
		return transactionAmount == null ? null : transactionAmount.doubleValue();
	}

	public String strTransactionAmount() {
		return transactionAmount == null ? "" : transactionAmount.setScale(2).toString();
	}

	public String jsonTransactionAmount() {
		return transactionAmount == null ? "" : transactionAmount.toString();
	}

	public String nomAffichageTransactionAmount() {
		return "date and time of the transaction";
	}

	public String htmTooltipTransactionAmount() {
		return null;
	}

	public String htmTransactionAmount() {
		return transactionAmount == null ? "" : StringEscapeUtils.escapeHtml4(strTransactionAmount());
	}

	/////////////////////////
	// transactionDateTime //
	/////////////////////////

	/**	L'entité « transactionDateTime »
	 *	 is defined as null before being initialized. 
	 */
	protected ZonedDateTime transactionDateTime;
	@JsonIgnore
	public Wrap<ZonedDateTime> transactionDateTimeWrap = new Wrap<ZonedDateTime>().p(this).c(ZonedDateTime.class).var("transactionDateTime").o(transactionDateTime);

	/**	<br/>L'entité « transactionDateTime »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.adjustment.BankAdjustment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:transactionDateTime">Trouver l'entité transactionDateTime dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _transactionDateTime(Wrap<ZonedDateTime> c);

	public ZonedDateTime getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(ZonedDateTime transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
		this.transactionDateTimeWrap.alreadyInitialized = true;
	}
	public BankAdjustment setTransactionDateTime(Instant o) {
		this.transactionDateTime = ZonedDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
		this.transactionDateTimeWrap.alreadyInitialized = true;
		return (BankAdjustment)this;
	}
	/** Example: 2011-12-03T10:15:30+01:00 **/
	public BankAdjustment setTransactionDateTime(String o) {
		this.transactionDateTime = ZonedDateTime.parse(o, DateTimeFormatter.ISO_OFFSET_DATE_TIME.withZone(ZoneId.of(siteRequest_.getSiteConfig_().getSiteZone()))).truncatedTo(ChronoUnit.MILLIS);
		this.transactionDateTimeWrap.alreadyInitialized = true;
		return (BankAdjustment)this;
	}
	public BankAdjustment setTransactionDateTime(Date o) {
		this.transactionDateTime = ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getSiteConfig_().getSiteZone())).truncatedTo(ChronoUnit.MILLIS);
		this.transactionDateTimeWrap.alreadyInitialized = true;
		return (BankAdjustment)this;
	}
	protected BankAdjustment transactionDateTimeInit() {
		if(!transactionDateTimeWrap.alreadyInitialized) {
			_transactionDateTime(transactionDateTimeWrap);
			if(transactionDateTime == null)
				setTransactionDateTime(transactionDateTimeWrap.o);
		}
		transactionDateTimeWrap.alreadyInitialized(true);
		return (BankAdjustment)this;
	}

	public Date solrTransactionDateTime() {
		return transactionDateTime == null ? null : Date.from(transactionDateTime.toInstant());
	}

	public String strTransactionDateTime() {
		return transactionDateTime == null ? "" : transactionDateTime.format(DateTimeFormatter.ofPattern("EEE MMM d, yyyy h:mm:ss a zz", Locale.US));
	}

	public String jsonTransactionDateTime() {
		return transactionDateTime == null ? "" : transactionDateTime.format(DateTimeFormatter.ofPattern("EEE MMM d yyyy h:mm:ss.SSS a zz VV", Locale.US));
	}

	public String nomAffichageTransactionDateTime() {
		return "date and time of the transaction";
	}

	public String htmTooltipTransactionDateTime() {
		return null;
	}

	public String htmTransactionDateTime() {
		return transactionDateTime == null ? "" : StringEscapeUtils.escapeHtml4(strTransactionDateTime());
	}

	/////////////////////
	// transactionDate //
	/////////////////////

	/**	L'entité « transactionDate »
	 *	 is defined as null before being initialized. 
	 */
	protected LocalDate transactionDate;
	@JsonIgnore
	public Wrap<LocalDate> transactionDateWrap = new Wrap<LocalDate>().p(this).c(LocalDate.class).var("transactionDate").o(transactionDate);

	/**	<br/>L'entité « transactionDate »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.adjustment.BankAdjustment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:transactionDate">Trouver l'entité transactionDate dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _transactionDate(Wrap<LocalDate> c);

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
		this.transactionDateWrap.alreadyInitialized = true;
	}
	public BankAdjustment setTransactionDate(Instant o) {
		this.transactionDate = LocalDate.from(o);
		this.transactionDateWrap.alreadyInitialized = true;
		return (BankAdjustment)this;
	}
	/** Example: 2011-12-03+01:00 **/
	public BankAdjustment setTransactionDate(String o) {
		this.transactionDate = LocalDate.parse(o, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		this.transactionDateWrap.alreadyInitialized = true;
		return (BankAdjustment)this;
	}
	public BankAdjustment setTransactionDate(Date o) {
		this.transactionDate = o.toInstant().atZone(ZoneId.of(siteRequest_.getSiteConfig_().getSiteZone())).toLocalDate();
		this.transactionDateWrap.alreadyInitialized = true;
		return (BankAdjustment)this;
	}
	protected BankAdjustment transactionDateInit() {
		if(!transactionDateWrap.alreadyInitialized) {
			_transactionDate(transactionDateWrap);
			if(transactionDate == null)
				setTransactionDate(transactionDateWrap.o);
		}
		transactionDateWrap.alreadyInitialized(true);
		return (BankAdjustment)this;
	}

	public Date solrTransactionDate() {
		return transactionDate == null ? null : Date.from(transactionDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public String strTransactionDate() {
		return transactionDate == null ? "" : transactionDate.format(DateTimeFormatter.ofPattern("EEE MMM d yyyy", Locale.US));
	}

	public String jsonTransactionDate() {
		return transactionDate == null ? "" : transactionDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.US));
	}

	public String nomAffichageTransactionDate() {
		return "date of the transaction";
	}

	public String htmTooltipTransactionDate() {
		return null;
	}

	public String htmTransactionDate() {
		return transactionDate == null ? "" : StringEscapeUtils.escapeHtml4(strTransactionDate());
	}

	////////////////////
	// transactionFee //
	////////////////////

	/**	L'entité « transactionFee »
	 *	 is defined as null before being initialized. 
	 */
	protected Boolean transactionFee;
	@JsonIgnore
	public Wrap<Boolean> transactionFeeWrap = new Wrap<Boolean>().p(this).c(Boolean.class).var("transactionFee").o(transactionFee);

	/**	<br/>L'entité « transactionFee »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.adjustment.BankAdjustment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:transactionFee">Trouver l'entité transactionFee dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _transactionFee(Wrap<Boolean> c);

	public Boolean getTransactionFee() {
		return transactionFee;
	}

	public void setTransactionFee(Boolean transactionFee) {
		this.transactionFee = transactionFee;
		this.transactionFeeWrap.alreadyInitialized = true;
	}
	public BankAdjustment setTransactionFee(String o) {
		this.transactionFee = Boolean.parseBoolean(o);
		this.transactionFeeWrap.alreadyInitialized = true;
		return (BankAdjustment)this;
	}
	protected BankAdjustment transactionFeeInit() {
		if(!transactionFeeWrap.alreadyInitialized) {
			_transactionFee(transactionFeeWrap);
			if(transactionFee == null)
				setTransactionFee(transactionFeeWrap.o);
		}
		transactionFeeWrap.alreadyInitialized(true);
		return (BankAdjustment)this;
	}

	public Boolean solrTransactionFee() {
		return transactionFee;
	}

	public String strTransactionFee() {
		return transactionFee == null ? "" : transactionFee.toString();
	}

	public String jsonTransactionFee() {
		return transactionFee == null ? "" : transactionFee.toString();
	}

	public String nomAffichageTransactionFee() {
		return "fee transaction";
	}

	public String htmTooltipTransactionFee() {
		return null;
	}

	public String htmTransactionFee() {
		return transactionFee == null ? "" : StringEscapeUtils.escapeHtml4(strTransactionFee());
	}

	////////////////
	// agentAreas //
	////////////////

	/**	L'entité « agentAreas »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut List<String>(). 
	 */
	protected List<String> agentAreas = new java.util.ArrayList<java.lang.String>();
	@JsonIgnore
	public Wrap<List<String>> agentAreasWrap = new Wrap<List<String>>().p(this).c(List.class).var("agentAreas").o(agentAreas);

	/**	<br/>L'entité « agentAreas »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut List<String>(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.adjustment.BankAdjustment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:agentAreas">Trouver l'entité agentAreas dans Solr</a>
	 * <br/>
	 * @param agentAreas est l'entité déjà construit. 
	 **/
	protected abstract void _agentAreas(List<String> l);

	public List<String> getAgentAreas() {
		return agentAreas;
	}

	public void setAgentAreas(List<String> agentAreas) {
		this.agentAreas = agentAreas;
		this.agentAreasWrap.alreadyInitialized = true;
	}
	public BankAdjustment addAgentAreas(String...objets) {
		for(String o : objets) {
			addAgentAreas(o);
		}
		return (BankAdjustment)this;
	}
	public BankAdjustment addAgentAreas(String o) {
		if(o != null && !agentAreas.contains(o))
			this.agentAreas.add(o);
		return (BankAdjustment)this;
	}
	public BankAdjustment setAgentAreas(JsonArray objets) {
		agentAreas.clear();
		for(int i = 0; i < objets.size(); i++) {
			String o = objets.getString(i);
			addAgentAreas(o);
		}
		return (BankAdjustment)this;
	}
	protected BankAdjustment agentAreasInit() {
		if(!agentAreasWrap.alreadyInitialized) {
			_agentAreas(agentAreas);
		}
		agentAreasWrap.alreadyInitialized(true);
		return (BankAdjustment)this;
	}

	public List<String> solrAgentAreas() {
		return agentAreas;
	}

	public String strAgentAreas() {
		return agentAreas == null ? "" : agentAreas.toString();
	}

	public String jsonAgentAreas() {
		return agentAreas == null ? "" : agentAreas.toString();
	}

	public String nomAffichageAgentAreas() {
		return "agent areas";
	}

	public String htmTooltipAgentAreas() {
		return null;
	}

	public String htmAgentAreas() {
		return agentAreas == null ? "" : StringEscapeUtils.escapeHtml4(strAgentAreas());
	}

	public void inputAgentAreas(String classApiMethodMethod) {
		BankAdjustment s = (BankAdjustment)this;
		e("input")
			.a("type", "text")
			.a("placeholder", "agent areas")
			.a("id", classApiMethodMethod, "_agentAreas");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setAgentAreas inputBankAdjustment", pk, "AgentAreas w3-input w3-border ");
				a("name", "setAgentAreas");
			} else {
				a("class", "valueAgentAreas w3-input w3-border inputBankAdjustment", pk, "AgentAreas w3-input w3-border ");
				a("name", "agentAreas");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchBankAdjustmentVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setAgentAreas', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_agentAreas')); }, function() { addError($('#", classApiMethodMethod, "_agentAreas')); }); ");
			}
			a("value", strAgentAreas())
		.fg();

	}

	public void htmAgentAreas(String classApiMethodMethod) {
		BankAdjustment s = (BankAdjustment)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestBankAdjustmentAgentAreas").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_agentAreas").a("class", "").f().sx("agent areas").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputAgentAreas(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_agentAreas')); $('#", classApiMethodMethod, "_agentAreas').val(null); patchBankAdjustmentVal([{ name: 'fq', value: 'pk:' + $('#BankAdjustmentForm :input[name=pk]').val() }], 'setAgentAreas', null, function() { addGlow($('#", classApiMethodMethod, "_agentAreas')); }, function() { addError($('#", classApiMethodMethod, "_agentAreas')); }); ")
										.f();
										e("i").a("class", "far fa-eraser ").f().g("i");
									} g("button");
								} g("div");
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	////////////////
	// agentRoles //
	////////////////

	/**	L'entité « agentRoles »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut List<String>(). 
	 */
	protected List<String> agentRoles = new java.util.ArrayList<java.lang.String>();
	@JsonIgnore
	public Wrap<List<String>> agentRolesWrap = new Wrap<List<String>>().p(this).c(List.class).var("agentRoles").o(agentRoles);

	/**	<br/>L'entité « agentRoles »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut List<String>(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.adjustment.BankAdjustment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:agentRoles">Trouver l'entité agentRoles dans Solr</a>
	 * <br/>
	 * @param agentRoles est l'entité déjà construit. 
	 **/
	protected abstract void _agentRoles(List<String> l);

	public List<String> getAgentRoles() {
		return agentRoles;
	}

	public void setAgentRoles(List<String> agentRoles) {
		this.agentRoles = agentRoles;
		this.agentRolesWrap.alreadyInitialized = true;
	}
	public BankAdjustment addAgentRoles(String...objets) {
		for(String o : objets) {
			addAgentRoles(o);
		}
		return (BankAdjustment)this;
	}
	public BankAdjustment addAgentRoles(String o) {
		if(o != null && !agentRoles.contains(o))
			this.agentRoles.add(o);
		return (BankAdjustment)this;
	}
	public BankAdjustment setAgentRoles(JsonArray objets) {
		agentRoles.clear();
		for(int i = 0; i < objets.size(); i++) {
			String o = objets.getString(i);
			addAgentRoles(o);
		}
		return (BankAdjustment)this;
	}
	protected BankAdjustment agentRolesInit() {
		if(!agentRolesWrap.alreadyInitialized) {
			_agentRoles(agentRoles);
		}
		agentRolesWrap.alreadyInitialized(true);
		return (BankAdjustment)this;
	}

	public List<String> solrAgentRoles() {
		return agentRoles;
	}

	public String strAgentRoles() {
		return agentRoles == null ? "" : agentRoles.toString();
	}

	public String jsonAgentRoles() {
		return agentRoles == null ? "" : agentRoles.toString();
	}

	public String nomAffichageAgentRoles() {
		return "agent roles";
	}

	public String htmTooltipAgentRoles() {
		return null;
	}

	public String htmAgentRoles() {
		return agentRoles == null ? "" : StringEscapeUtils.escapeHtml4(strAgentRoles());
	}

	public void inputAgentRoles(String classApiMethodMethod) {
		BankAdjustment s = (BankAdjustment)this;
		e("input")
			.a("type", "text")
			.a("placeholder", "agent roles")
			.a("id", classApiMethodMethod, "_agentRoles");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setAgentRoles inputBankAdjustment", pk, "AgentRoles w3-input w3-border ");
				a("name", "setAgentRoles");
			} else {
				a("class", "valueAgentRoles w3-input w3-border inputBankAdjustment", pk, "AgentRoles w3-input w3-border ");
				a("name", "agentRoles");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchBankAdjustmentVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setAgentRoles', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_agentRoles')); }, function() { addError($('#", classApiMethodMethod, "_agentRoles')); }); ");
			}
			a("value", strAgentRoles())
		.fg();

	}

	public void htmAgentRoles(String classApiMethodMethod) {
		BankAdjustment s = (BankAdjustment)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestBankAdjustmentAgentRoles").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_agentRoles").a("class", "").f().sx("agent roles").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputAgentRoles(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_agentRoles')); $('#", classApiMethodMethod, "_agentRoles').val(null); patchBankAdjustmentVal([{ name: 'fq', value: 'pk:' + $('#BankAdjustmentForm :input[name=pk]').val() }], 'setAgentRoles', null, function() { addGlow($('#", classApiMethodMethod, "_agentRoles')); }, function() { addError($('#", classApiMethodMethod, "_agentRoles')); }); ")
										.f();
										e("i").a("class", "far fa-eraser ").f().g("i");
									} g("button");
								} g("div");
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	///////////////////
	// agentOverride //
	///////////////////

	/**	L'entité « agentOverride »
	 *	 is defined as null before being initialized. 
	 */
	protected Boolean agentOverride;
	@JsonIgnore
	public Wrap<Boolean> agentOverrideWrap = new Wrap<Boolean>().p(this).c(Boolean.class).var("agentOverride").o(agentOverride);

	/**	<br/>L'entité « agentOverride »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.adjustment.BankAdjustment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:agentOverride">Trouver l'entité agentOverride dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _agentOverride(Wrap<Boolean> c);

	public Boolean getAgentOverride() {
		return agentOverride;
	}

	public void setAgentOverride(Boolean agentOverride) {
		this.agentOverride = agentOverride;
		this.agentOverrideWrap.alreadyInitialized = true;
	}
	public BankAdjustment setAgentOverride(String o) {
		this.agentOverride = Boolean.parseBoolean(o);
		this.agentOverrideWrap.alreadyInitialized = true;
		return (BankAdjustment)this;
	}
	protected BankAdjustment agentOverrideInit() {
		if(!agentOverrideWrap.alreadyInitialized) {
			_agentOverride(agentOverrideWrap);
			if(agentOverride == null)
				setAgentOverride(agentOverrideWrap.o);
		}
		agentOverrideWrap.alreadyInitialized(true);
		return (BankAdjustment)this;
	}

	public Boolean solrAgentOverride() {
		return agentOverride;
	}

	public String strAgentOverride() {
		return agentOverride == null ? "" : agentOverride.toString();
	}

	public String jsonAgentOverride() {
		return agentOverride == null ? "" : agentOverride.toString();
	}

	public String nomAffichageAgentOverride() {
		return "agent can override";
	}

	public String htmTooltipAgentOverride() {
		return null;
	}

	public String htmAgentOverride() {
		return agentOverride == null ? "" : StringEscapeUtils.escapeHtml4(strAgentOverride());
	}

	public void inputAgentOverride(String classApiMethodMethod) {
		BankAdjustment s = (BankAdjustment)this;
		e("input")
			.a("type", "checkbox")
			.a("id", classApiMethodMethod, "_agentOverride")
			.a("value", "true");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setAgentOverride inputBankAdjustment", pk, "AgentOverride w3-input w3-border ");
				a("name", "setAgentOverride");
			} else {
				a("class", "valueAgentOverride inputBankAdjustment", pk, "AgentOverride w3-input w3-border ");
				a("name", "agentOverride");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onchange", "patchBankAdjustmentVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setAgentOverride', $(this).prop('checked'), function() { addGlow($('#", classApiMethodMethod, "_agentOverride')); }, function() { addError($('#", classApiMethodMethod, "_agentOverride')); }); ");
			}
			;
			if(getAgentOverride() != null && getAgentOverride())
				a("checked", "checked");
		fg();

	}

	public void htmAgentOverride(String classApiMethodMethod) {
		BankAdjustment s = (BankAdjustment)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestBankAdjustmentAgentOverride").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_agentOverride").a("class", "").f().sx("agent can override").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputAgentOverride(classApiMethodMethod);
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	/////////////////////////
	// eligibleEntitlement //
	/////////////////////////

	/**	L'entité « eligibleEntitlement »
	 *	 is defined as null before being initialized. 
	 */
	protected Boolean eligibleEntitlement;
	@JsonIgnore
	public Wrap<Boolean> eligibleEntitlementWrap = new Wrap<Boolean>().p(this).c(Boolean.class).var("eligibleEntitlement").o(eligibleEntitlement);

	/**	<br/>L'entité « eligibleEntitlement »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.adjustment.BankAdjustment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:eligibleEntitlement">Trouver l'entité eligibleEntitlement dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _eligibleEntitlement(Wrap<Boolean> c);

	public Boolean getEligibleEntitlement() {
		return eligibleEntitlement;
	}

	public void setEligibleEntitlement(Boolean eligibleEntitlement) {
		this.eligibleEntitlement = eligibleEntitlement;
		this.eligibleEntitlementWrap.alreadyInitialized = true;
	}
	public BankAdjustment setEligibleEntitlement(String o) {
		this.eligibleEntitlement = Boolean.parseBoolean(o);
		this.eligibleEntitlementWrap.alreadyInitialized = true;
		return (BankAdjustment)this;
	}
	protected BankAdjustment eligibleEntitlementInit() {
		if(!eligibleEntitlementWrap.alreadyInitialized) {
			_eligibleEntitlement(eligibleEntitlementWrap);
			if(eligibleEntitlement == null)
				setEligibleEntitlement(eligibleEntitlementWrap.o);
		}
		eligibleEntitlementWrap.alreadyInitialized(true);
		return (BankAdjustment)this;
	}

	public Boolean solrEligibleEntitlement() {
		return eligibleEntitlement;
	}

	public String strEligibleEntitlement() {
		return eligibleEntitlement == null ? "" : eligibleEntitlement.toString();
	}

	public String jsonEligibleEntitlement() {
		return eligibleEntitlement == null ? "" : eligibleEntitlement.toString();
	}

	public String nomAffichageEligibleEntitlement() {
		return "eligible entitlement";
	}

	public String htmTooltipEligibleEntitlement() {
		return null;
	}

	public String htmEligibleEntitlement() {
		return eligibleEntitlement == null ? "" : StringEscapeUtils.escapeHtml4(strEligibleEntitlement());
	}

	public void inputEligibleEntitlement(String classApiMethodMethod) {
		BankAdjustment s = (BankAdjustment)this;
		e("input")
			.a("type", "checkbox")
			.a("id", classApiMethodMethod, "_eligibleEntitlement")
			.a("value", "true");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setEligibleEntitlement inputBankAdjustment", pk, "EligibleEntitlement w3-input w3-border ");
				a("name", "setEligibleEntitlement");
			} else {
				a("class", "valueEligibleEntitlement inputBankAdjustment", pk, "EligibleEntitlement w3-input w3-border ");
				a("name", "eligibleEntitlement");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onchange", "patchBankAdjustmentVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setEligibleEntitlement', $(this).prop('checked'), function() { addGlow($('#", classApiMethodMethod, "_eligibleEntitlement')); }, function() { addError($('#", classApiMethodMethod, "_eligibleEntitlement')); }); ");
			}
			;
			if(getEligibleEntitlement() != null && getEligibleEntitlement())
				a("checked", "checked");
		fg();

	}

	public void htmEligibleEntitlement(String classApiMethodMethod) {
		BankAdjustment s = (BankAdjustment)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestBankAdjustmentEligibleEntitlement").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_eligibleEntitlement").a("class", "").f().sx("eligible entitlement").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputEligibleEntitlement(classApiMethodMethod);
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	/////////////////
	// partnerName //
	/////////////////

	/**	L'entité « partnerName »
	 *	 is defined as null before being initialized. 
	 */
	protected String partnerName;
	@JsonIgnore
	public Wrap<String> partnerNameWrap = new Wrap<String>().p(this).c(String.class).var("partnerName").o(partnerName);

	/**	<br/>L'entité « partnerName »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.adjustment.BankAdjustment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:partnerName">Trouver l'entité partnerName dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _partnerName(Wrap<String> c);

	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
		this.partnerNameWrap.alreadyInitialized = true;
	}
	protected BankAdjustment partnerNameInit() {
		if(!partnerNameWrap.alreadyInitialized) {
			_partnerName(partnerNameWrap);
			if(partnerName == null)
				setPartnerName(partnerNameWrap.o);
		}
		partnerNameWrap.alreadyInitialized(true);
		return (BankAdjustment)this;
	}

	public String solrPartnerName() {
		return partnerName;
	}

	public String strPartnerName() {
		return partnerName == null ? "" : partnerName;
	}

	public String jsonPartnerName() {
		return partnerName == null ? "" : partnerName;
	}

	public String nomAffichagePartnerName() {
		return "partner name";
	}

	public String htmTooltipPartnerName() {
		return null;
	}

	public String htmPartnerName() {
		return partnerName == null ? "" : StringEscapeUtils.escapeHtml4(strPartnerName());
	}

	public void inputPartnerName(String classApiMethodMethod) {
		BankAdjustment s = (BankAdjustment)this;
		e("input")
			.a("type", "text")
			.a("placeholder", "partner name")
			.a("id", classApiMethodMethod, "_partnerName");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setPartnerName inputBankAdjustment", pk, "PartnerName w3-input w3-border ");
				a("name", "setPartnerName");
			} else {
				a("class", "valuePartnerName w3-input w3-border inputBankAdjustment", pk, "PartnerName w3-input w3-border ");
				a("name", "partnerName");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchBankAdjustmentVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setPartnerName', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_partnerName')); }, function() { addError($('#", classApiMethodMethod, "_partnerName')); }); ");
			}
			a("value", strPartnerName())
		.fg();

	}

	public void htmPartnerName(String classApiMethodMethod) {
		BankAdjustment s = (BankAdjustment)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestBankAdjustmentPartnerName").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_partnerName").a("class", "").f().sx("partner name").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputPartnerName(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_partnerName')); $('#", classApiMethodMethod, "_partnerName').val(null); patchBankAdjustmentVal([{ name: 'fq', value: 'pk:' + $('#BankAdjustmentForm :input[name=pk]').val() }], 'setPartnerName', null, function() { addGlow($('#", classApiMethodMethod, "_partnerName')); }, function() { addError($('#", classApiMethodMethod, "_partnerName')); }); ")
										.f();
										e("i").a("class", "far fa-eraser ").f().g("i");
									} g("button");
								} g("div");
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	///////////////////////////
	// adjustmentDisplayName //
	///////////////////////////

	/**	L'entité « adjustmentDisplayName »
	 *	 is defined as null before being initialized. 
	 */
	protected String adjustmentDisplayName;
	@JsonIgnore
	public Wrap<String> adjustmentDisplayNameWrap = new Wrap<String>().p(this).c(String.class).var("adjustmentDisplayName").o(adjustmentDisplayName);

	/**	<br/>L'entité « adjustmentDisplayName »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.adjustment.BankAdjustment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:adjustmentDisplayName">Trouver l'entité adjustmentDisplayName dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _adjustmentDisplayName(Wrap<String> c);

	public String getAdjustmentDisplayName() {
		return adjustmentDisplayName;
	}

	public void setAdjustmentDisplayName(String adjustmentDisplayName) {
		this.adjustmentDisplayName = adjustmentDisplayName;
		this.adjustmentDisplayNameWrap.alreadyInitialized = true;
	}
	protected BankAdjustment adjustmentDisplayNameInit() {
		if(!adjustmentDisplayNameWrap.alreadyInitialized) {
			_adjustmentDisplayName(adjustmentDisplayNameWrap);
			if(adjustmentDisplayName == null)
				setAdjustmentDisplayName(adjustmentDisplayNameWrap.o);
		}
		adjustmentDisplayNameWrap.alreadyInitialized(true);
		return (BankAdjustment)this;
	}

	public String solrAdjustmentDisplayName() {
		return adjustmentDisplayName;
	}

	public String strAdjustmentDisplayName() {
		return adjustmentDisplayName == null ? "" : adjustmentDisplayName;
	}

	public String jsonAdjustmentDisplayName() {
		return adjustmentDisplayName == null ? "" : adjustmentDisplayName;
	}

	public String nomAffichageAdjustmentDisplayName() {
		return "display name";
	}

	public String htmTooltipAdjustmentDisplayName() {
		return null;
	}

	public String htmAdjustmentDisplayName() {
		return adjustmentDisplayName == null ? "" : StringEscapeUtils.escapeHtml4(strAdjustmentDisplayName());
	}

	public void inputAdjustmentDisplayName(String classApiMethodMethod) {
		BankAdjustment s = (BankAdjustment)this;
		e("input")
			.a("type", "text")
			.a("placeholder", "display name")
			.a("id", classApiMethodMethod, "_adjustmentDisplayName");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setAdjustmentDisplayName inputBankAdjustment", pk, "AdjustmentDisplayName w3-input w3-border ");
				a("name", "setAdjustmentDisplayName");
			} else {
				a("class", "valueAdjustmentDisplayName w3-input w3-border inputBankAdjustment", pk, "AdjustmentDisplayName w3-input w3-border ");
				a("name", "adjustmentDisplayName");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchBankAdjustmentVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setAdjustmentDisplayName', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_adjustmentDisplayName')); }, function() { addError($('#", classApiMethodMethod, "_adjustmentDisplayName')); }); ");
			}
			a("value", strAdjustmentDisplayName())
		.fg();

	}

	public void htmAdjustmentDisplayName(String classApiMethodMethod) {
		BankAdjustment s = (BankAdjustment)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestBankAdjustmentAdjustmentDisplayName").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_adjustmentDisplayName").a("class", "").f().sx("display name").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputAdjustmentDisplayName(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_adjustmentDisplayName')); $('#", classApiMethodMethod, "_adjustmentDisplayName').val(null); patchBankAdjustmentVal([{ name: 'fq', value: 'pk:' + $('#BankAdjustmentForm :input[name=pk]').val() }], 'setAdjustmentDisplayName', null, function() { addGlow($('#", classApiMethodMethod, "_adjustmentDisplayName')); }, function() { addError($('#", classApiMethodMethod, "_adjustmentDisplayName')); }); ")
										.f();
										e("i").a("class", "far fa-eraser ").f().g("i");
									} g("button");
								} g("div");
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	////////////////////////////
	// adjustmentCompleteName //
	////////////////////////////

	/**	L'entité « adjustmentCompleteName »
	 *	 is defined as null before being initialized. 
	 */
	protected String adjustmentCompleteName;
	@JsonIgnore
	public Wrap<String> adjustmentCompleteNameWrap = new Wrap<String>().p(this).c(String.class).var("adjustmentCompleteName").o(adjustmentCompleteName);

	/**	<br/>L'entité « adjustmentCompleteName »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.adjustment.BankAdjustment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:adjustmentCompleteName">Trouver l'entité adjustmentCompleteName dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _adjustmentCompleteName(Wrap<String> c);

	public String getAdjustmentCompleteName() {
		return adjustmentCompleteName;
	}

	public void setAdjustmentCompleteName(String adjustmentCompleteName) {
		this.adjustmentCompleteName = adjustmentCompleteName;
		this.adjustmentCompleteNameWrap.alreadyInitialized = true;
	}
	protected BankAdjustment adjustmentCompleteNameInit() {
		if(!adjustmentCompleteNameWrap.alreadyInitialized) {
			_adjustmentCompleteName(adjustmentCompleteNameWrap);
			if(adjustmentCompleteName == null)
				setAdjustmentCompleteName(adjustmentCompleteNameWrap.o);
		}
		adjustmentCompleteNameWrap.alreadyInitialized(true);
		return (BankAdjustment)this;
	}

	public String solrAdjustmentCompleteName() {
		return adjustmentCompleteName;
	}

	public String strAdjustmentCompleteName() {
		return adjustmentCompleteName == null ? "" : adjustmentCompleteName;
	}

	public String jsonAdjustmentCompleteName() {
		return adjustmentCompleteName == null ? "" : adjustmentCompleteName;
	}

	public String nomAffichageAdjustmentCompleteName() {
		return null;
	}

	public String htmTooltipAdjustmentCompleteName() {
		return null;
	}

	public String htmAdjustmentCompleteName() {
		return adjustmentCompleteName == null ? "" : StringEscapeUtils.escapeHtml4(strAdjustmentCompleteName());
	}

	public void inputAdjustmentCompleteName(String classApiMethodMethod) {
		BankAdjustment s = (BankAdjustment)this;
	}

	public void htmAdjustmentCompleteName(String classApiMethodMethod) {
		BankAdjustment s = (BankAdjustment)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").f().sx(strAdjustmentCompleteName()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	//////////////////
	// adjustmentId //
	//////////////////

	/**	L'entité « adjustmentId »
	 *	 is defined as null before being initialized. 
	 */
	protected String adjustmentId;
	@JsonIgnore
	public Wrap<String> adjustmentIdWrap = new Wrap<String>().p(this).c(String.class).var("adjustmentId").o(adjustmentId);

	/**	<br/>L'entité « adjustmentId »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.adjustment.BankAdjustment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:adjustmentId">Trouver l'entité adjustmentId dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _adjustmentId(Wrap<String> c);

	public String getAdjustmentId() {
		return adjustmentId;
	}

	public void setAdjustmentId(String adjustmentId) {
		this.adjustmentId = adjustmentId;
		this.adjustmentIdWrap.alreadyInitialized = true;
	}
	protected BankAdjustment adjustmentIdInit() {
		if(!adjustmentIdWrap.alreadyInitialized) {
			_adjustmentId(adjustmentIdWrap);
			if(adjustmentId == null)
				setAdjustmentId(adjustmentIdWrap.o);
		}
		adjustmentIdWrap.alreadyInitialized(true);
		return (BankAdjustment)this;
	}

	public String solrAdjustmentId() {
		return adjustmentId;
	}

	public String strAdjustmentId() {
		return adjustmentId == null ? "" : adjustmentId;
	}

	public String jsonAdjustmentId() {
		return adjustmentId == null ? "" : adjustmentId;
	}

	public String nomAffichageAdjustmentId() {
		return "ID";
	}

	public String htmTooltipAdjustmentId() {
		return null;
	}

	public String htmAdjustmentId() {
		return adjustmentId == null ? "" : StringEscapeUtils.escapeHtml4(strAdjustmentId());
	}

	public void inputAdjustmentId(String classApiMethodMethod) {
		BankAdjustment s = (BankAdjustment)this;
	}

	public void htmAdjustmentId(String classApiMethodMethod) {
		BankAdjustment s = (BankAdjustment)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("class", "").f().sx("ID").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").f().sx(strAdjustmentId()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	/////////////
	// pageUrl //
	/////////////

	/**	L'entité « pageUrl »
	 *	 is defined as null before being initialized. 
	 */
	protected String pageUrl;
	@JsonIgnore
	public Wrap<String> pageUrlWrap = new Wrap<String>().p(this).c(String.class).var("pageUrl").o(pageUrl);

	/**	<br/>L'entité « pageUrl »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.adjustment.BankAdjustment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageUrl">Trouver l'entité pageUrl dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _pageUrl(Wrap<String> c);

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
		this.pageUrlWrap.alreadyInitialized = true;
	}
	protected BankAdjustment pageUrlInit() {
		if(!pageUrlWrap.alreadyInitialized) {
			_pageUrl(pageUrlWrap);
			if(pageUrl == null)
				setPageUrl(pageUrlWrap.o);
		}
		pageUrlWrap.alreadyInitialized(true);
		return (BankAdjustment)this;
	}

	public String solrPageUrl() {
		return pageUrl;
	}

	public String strPageUrl() {
		return pageUrl == null ? "" : pageUrl;
	}

	public String jsonPageUrl() {
		return pageUrl == null ? "" : pageUrl;
	}

	public String nomAffichagePageUrl() {
		return null;
	}

	public String htmTooltipPageUrl() {
		return null;
	}

	public String htmPageUrl() {
		return pageUrl == null ? "" : StringEscapeUtils.escapeHtml4(strPageUrl());
	}

	///////////////////
	// objectSuggest //
	///////////////////

	/**	L'entité « objectSuggest »
	 *	 is defined as null before being initialized. 
	 */
	protected String objectSuggest;
	@JsonIgnore
	public Wrap<String> objectSuggestWrap = new Wrap<String>().p(this).c(String.class).var("objectSuggest").o(objectSuggest);

	/**	<br/>L'entité « objectSuggest »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.adjustment.BankAdjustment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:objectSuggest">Trouver l'entité objectSuggest dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _objectSuggest(Wrap<String> c);

	public String getObjectSuggest() {
		return objectSuggest;
	}

	public void setObjectSuggest(String objectSuggest) {
		this.objectSuggest = objectSuggest;
		this.objectSuggestWrap.alreadyInitialized = true;
	}
	protected BankAdjustment objectSuggestInit() {
		if(!objectSuggestWrap.alreadyInitialized) {
			_objectSuggest(objectSuggestWrap);
			if(objectSuggest == null)
				setObjectSuggest(objectSuggestWrap.o);
		}
		objectSuggestWrap.alreadyInitialized(true);
		return (BankAdjustment)this;
	}

	public String solrObjectSuggest() {
		return objectSuggest;
	}

	public String strObjectSuggest() {
		return objectSuggest == null ? "" : objectSuggest;
	}

	public String jsonObjectSuggest() {
		return objectSuggest == null ? "" : objectSuggest;
	}

	public String nomAffichageObjectSuggest() {
		return null;
	}

	public String htmTooltipObjectSuggest() {
		return null;
	}

	public String htmObjectSuggest() {
		return objectSuggest == null ? "" : StringEscapeUtils.escapeHtml4(strObjectSuggest());
	}

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedBankAdjustment = false;

	public BankAdjustment initDeepBankAdjustment(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedBankAdjustment) {
			alreadyInitializedBankAdjustment = true;
			initDeepBankAdjustment();
		}
		return (BankAdjustment)this;
	}

	public void initDeepBankAdjustment() {
		initBankAdjustment();
		super.initDeepCluster(siteRequest_);
	}

	public void initBankAdjustment() {
		adjustmentKeyInit();
		accountKeyInit();
		accountSearchInit();
		account_Init();
		accountCompleteNameInit();
		accountNumberInit();
		transactionKeyInit();
		transactionSearchInit();
		transaction_Init();
		transactionReferenceIdInit();
		transactionCodeInit();
		transactionAmountInit();
		transactionDateTimeInit();
		transactionDateInit();
		transactionFeeInit();
		agentAreasInit();
		agentRolesInit();
		agentOverrideInit();
		eligibleEntitlementInit();
		partnerNameInit();
		adjustmentDisplayNameInit();
		adjustmentCompleteNameInit();
		adjustmentIdInit();
		pageUrlInit();
		objectSuggestInit();
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepBankAdjustment(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestBankAdjustment(SiteRequestEnUS siteRequest_) {
			super.siteRequestCluster(siteRequest_);
		if(accountSearch != null)
			accountSearch.setSiteRequest_(siteRequest_);
		if(transactionSearch != null)
			transactionSearch.setSiteRequest_(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestBankAdjustment(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainBankAdjustment(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainBankAdjustment(String var) {
		BankAdjustment oBankAdjustment = (BankAdjustment)this;
		switch(var) {
			case "adjustmentKey":
				return oBankAdjustment.adjustmentKey;
			case "accountKey":
				return oBankAdjustment.accountKey;
			case "accountSearch":
				return oBankAdjustment.accountSearch;
			case "account_":
				return oBankAdjustment.account_;
			case "accountCompleteName":
				return oBankAdjustment.accountCompleteName;
			case "accountNumber":
				return oBankAdjustment.accountNumber;
			case "transactionKey":
				return oBankAdjustment.transactionKey;
			case "transactionSearch":
				return oBankAdjustment.transactionSearch;
			case "transaction_":
				return oBankAdjustment.transaction_;
			case "transactionReferenceId":
				return oBankAdjustment.transactionReferenceId;
			case "transactionCode":
				return oBankAdjustment.transactionCode;
			case "transactionAmount":
				return oBankAdjustment.transactionAmount;
			case "transactionDateTime":
				return oBankAdjustment.transactionDateTime;
			case "transactionDate":
				return oBankAdjustment.transactionDate;
			case "transactionFee":
				return oBankAdjustment.transactionFee;
			case "agentAreas":
				return oBankAdjustment.agentAreas;
			case "agentRoles":
				return oBankAdjustment.agentRoles;
			case "agentOverride":
				return oBankAdjustment.agentOverride;
			case "eligibleEntitlement":
				return oBankAdjustment.eligibleEntitlement;
			case "partnerName":
				return oBankAdjustment.partnerName;
			case "adjustmentDisplayName":
				return oBankAdjustment.adjustmentDisplayName;
			case "adjustmentCompleteName":
				return oBankAdjustment.adjustmentCompleteName;
			case "adjustmentId":
				return oBankAdjustment.adjustmentId;
			case "pageUrl":
				return oBankAdjustment.pageUrl;
			case "objectSuggest":
				return oBankAdjustment.objectSuggest;
			default:
				return super.obtainCluster(var);
		}
	}

	///////////////
	// attribute //
	///////////////

	@Override public boolean attributeForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = attributeBankAdjustment(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeBankAdjustment(String var, Object val) {
		BankAdjustment oBankAdjustment = (BankAdjustment)this;
		switch(var) {
			default:
				return super.attributeCluster(var, val);
		}
	}

	/////////////
	// define //
	/////////////

	@Override public boolean defineForClass(String var, String val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = defineBankAdjustment(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineBankAdjustment(String var, String val) {
		switch(var) {
			case "agentAreas":
				addAgentAreas(val);
				if(!savesBankAdjustment.contains(var))
					savesBankAdjustment.add(var);
				return val;
			case "agentRoles":
				addAgentRoles(val);
				if(!savesBankAdjustment.contains(var))
					savesBankAdjustment.add(var);
				return val;
			case "agentOverride":
				setAgentOverride(val);
				savesBankAdjustment.add(var);
				return val;
			case "eligibleEntitlement":
				setEligibleEntitlement(val);
				savesBankAdjustment.add(var);
				return val;
			case "partnerName":
				setPartnerName(val);
				savesBankAdjustment.add(var);
				return val;
			case "adjustmentDisplayName":
				setAdjustmentDisplayName(val);
				savesBankAdjustment.add(var);
				return val;
			default:
				return super.defineCluster(var, val);
		}
	}

	/////////////////
	// saves //
	/////////////////

	protected List<String> savesBankAdjustment = new ArrayList<String>();

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrDocument solrDocument) {
		populateBankAdjustment(solrDocument);
	}
	public void populateBankAdjustment(SolrDocument solrDocument) {
		BankAdjustment oBankAdjustment = (BankAdjustment)this;
		savesBankAdjustment = (List<String>)solrDocument.get("savesBankAdjustment_stored_strings");
		if(savesBankAdjustment != null) {

			if(savesBankAdjustment.contains("adjustmentKey")) {
				Long adjustmentKey = (Long)solrDocument.get("adjustmentKey_stored_long");
				if(adjustmentKey != null)
					oBankAdjustment.setAdjustmentKey(adjustmentKey);
			}

			if(savesBankAdjustment.contains("accountKey")) {
				Long accountKey = (Long)solrDocument.get("accountKey_stored_long");
				if(accountKey != null)
					oBankAdjustment.setAccountKey(accountKey);
			}

			if(savesBankAdjustment.contains("accountCompleteName")) {
				String accountCompleteName = (String)solrDocument.get("accountCompleteName_stored_string");
				if(accountCompleteName != null)
					oBankAdjustment.setAccountCompleteName(accountCompleteName);
			}

			if(savesBankAdjustment.contains("accountNumber")) {
				String accountNumber = (String)solrDocument.get("accountNumber_stored_string");
				if(accountNumber != null)
					oBankAdjustment.setAccountNumber(accountNumber);
			}

			if(savesBankAdjustment.contains("transactionKey")) {
				Long transactionKey = (Long)solrDocument.get("transactionKey_stored_long");
				if(transactionKey != null)
					oBankAdjustment.setTransactionKey(transactionKey);
			}

			if(savesBankAdjustment.contains("transactionReferenceId")) {
				String transactionReferenceId = (String)solrDocument.get("transactionReferenceId_stored_string");
				if(transactionReferenceId != null)
					oBankAdjustment.setTransactionReferenceId(transactionReferenceId);
			}

			if(savesBankAdjustment.contains("transactionCode")) {
				String transactionCode = (String)solrDocument.get("transactionCode_stored_string");
				if(transactionCode != null)
					oBankAdjustment.setTransactionCode(transactionCode);
			}

			if(savesBankAdjustment.contains("transactionAmount")) {
				Double transactionAmount = (Double)solrDocument.get("transactionAmount_stored_double");
				if(transactionAmount != null)
					oBankAdjustment.setTransactionAmount(transactionAmount);
			}

			if(savesBankAdjustment.contains("transactionDateTime")) {
				Date transactionDateTime = (Date)solrDocument.get("transactionDateTime_stored_date");
				if(transactionDateTime != null)
					oBankAdjustment.setTransactionDateTime(transactionDateTime);
			}

			if(savesBankAdjustment.contains("transactionDate")) {
				Date transactionDate = (Date)solrDocument.get("transactionDate_stored_date");
				if(transactionDate != null)
					oBankAdjustment.setTransactionDate(transactionDate);
			}

			if(savesBankAdjustment.contains("transactionFee")) {
				Boolean transactionFee = (Boolean)solrDocument.get("transactionFee_stored_boolean");
				if(transactionFee != null)
					oBankAdjustment.setTransactionFee(transactionFee);
			}

			if(savesBankAdjustment.contains("agentAreas")) {
				List<String> agentAreas = (List<String>)solrDocument.get("agentAreas_stored_strings");
				if(agentAreas != null)
					oBankAdjustment.agentAreas.addAll(agentAreas);
			}

			if(savesBankAdjustment.contains("agentRoles")) {
				List<String> agentRoles = (List<String>)solrDocument.get("agentRoles_stored_strings");
				if(agentRoles != null)
					oBankAdjustment.agentRoles.addAll(agentRoles);
			}

			if(savesBankAdjustment.contains("agentOverride")) {
				Boolean agentOverride = (Boolean)solrDocument.get("agentOverride_stored_boolean");
				if(agentOverride != null)
					oBankAdjustment.setAgentOverride(agentOverride);
			}

			if(savesBankAdjustment.contains("eligibleEntitlement")) {
				Boolean eligibleEntitlement = (Boolean)solrDocument.get("eligibleEntitlement_stored_boolean");
				if(eligibleEntitlement != null)
					oBankAdjustment.setEligibleEntitlement(eligibleEntitlement);
			}

			if(savesBankAdjustment.contains("partnerName")) {
				String partnerName = (String)solrDocument.get("partnerName_stored_string");
				if(partnerName != null)
					oBankAdjustment.setPartnerName(partnerName);
			}

			if(savesBankAdjustment.contains("adjustmentDisplayName")) {
				String adjustmentDisplayName = (String)solrDocument.get("adjustmentDisplayName_stored_string");
				if(adjustmentDisplayName != null)
					oBankAdjustment.setAdjustmentDisplayName(adjustmentDisplayName);
			}

			if(savesBankAdjustment.contains("adjustmentCompleteName")) {
				String adjustmentCompleteName = (String)solrDocument.get("adjustmentCompleteName_stored_string");
				if(adjustmentCompleteName != null)
					oBankAdjustment.setAdjustmentCompleteName(adjustmentCompleteName);
			}

			if(savesBankAdjustment.contains("adjustmentId")) {
				String adjustmentId = (String)solrDocument.get("adjustmentId_stored_string");
				if(adjustmentId != null)
					oBankAdjustment.setAdjustmentId(adjustmentId);
			}

			if(savesBankAdjustment.contains("pageUrl")) {
				String pageUrl = (String)solrDocument.get("pageUrl_stored_string");
				if(pageUrl != null)
					oBankAdjustment.setPageUrl(pageUrl);
			}

			if(savesBankAdjustment.contains("objectSuggest")) {
				String objectSuggest = (String)solrDocument.get("objectSuggest_suggested");
				oBankAdjustment.setObjectSuggest(objectSuggest);
			}
		}

		super.populateCluster(solrDocument);
	}

	/////////////
	// index //
	/////////////

	public static void index() {
		try {
			SiteRequestEnUS siteRequest = new SiteRequestEnUS();
			siteRequest.initDeepSiteRequestEnUS();
			SiteContextEnUS siteContext = new SiteContextEnUS();
			siteContext.getSiteConfig().setConfigPath("/usr/local/src/computate-bancaire/computate-bancaire-commun/config/computate-bancaire-commun.config");
			siteContext.initDeepSiteContextEnUS();
			siteRequest.setSiteContext_(siteContext);
			siteRequest.setSiteConfig_(siteContext.getSiteConfig());
			SolrQuery solrQuery = new SolrQuery();
			solrQuery.setQuery("*:*");
			solrQuery.setRows(1);
			solrQuery.addFilterQuery("id:" + ClientUtils.escapeQueryChars("org.computate.bancaire.enus.adjustment.BankAdjustment"));
			QueryResponse queryResponse = siteRequest.getSiteContext_().getSolrClient().query(solrQuery);
			if(queryResponse.getResults().size() > 0)
				siteRequest.setSolrDocument(queryResponse.getResults().get(0));
			BankAdjustment o = new BankAdjustment();
			o.siteRequestBankAdjustment(siteRequest);
			o.initDeepBankAdjustment(siteRequest);
			o.indexBankAdjustment();
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}


	@Override public void indexForClass() {
		indexBankAdjustment();
	}

	@Override public void indexForClass(SolrInputDocument document) {
		indexBankAdjustment(document);
	}

	public void indexBankAdjustment(SolrClient clientSolr) {
		try {
			SolrInputDocument document = new SolrInputDocument();
			indexBankAdjustment(document);
			clientSolr.add(document);
			clientSolr.commit(false, false, true);
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public void indexBankAdjustment() {
		try {
			SolrInputDocument document = new SolrInputDocument();
			indexBankAdjustment(document);
			SolrClient clientSolr = siteRequest_.getSiteContext_().getSolrClient();
			clientSolr.add(document);
			clientSolr.commit(false, false, true);
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public void indexBankAdjustment(SolrInputDocument document) {
		if(savesBankAdjustment != null)
			document.addField("savesBankAdjustment_stored_strings", savesBankAdjustment);

		if(adjustmentKey != null) {
			document.addField("adjustmentKey_indexed_long", adjustmentKey);
			document.addField("adjustmentKey_stored_long", adjustmentKey);
		}
		if(accountKey != null) {
			document.addField("accountKey_indexed_long", accountKey);
			document.addField("accountKey_stored_long", accountKey);
		}
		if(accountCompleteName != null) {
			document.addField("accountCompleteName_indexed_string", accountCompleteName);
			document.addField("accountCompleteName_stored_string", accountCompleteName);
		}
		if(accountNumber != null) {
			document.addField("accountNumber_indexed_string", accountNumber);
			document.addField("accountNumber_stored_string", accountNumber);
		}
		if(transactionKey != null) {
			document.addField("transactionKey_indexed_long", transactionKey);
			document.addField("transactionKey_stored_long", transactionKey);
		}
		if(transactionReferenceId != null) {
			document.addField("transactionReferenceId_indexed_string", transactionReferenceId);
			document.addField("transactionReferenceId_stored_string", transactionReferenceId);
		}
		if(transactionCode != null) {
			document.addField("transactionCode_indexed_string", transactionCode);
			document.addField("transactionCode_stored_string", transactionCode);
		}
		if(transactionAmount != null) {
			document.addField("transactionAmount_indexed_double", transactionAmount.doubleValue());
			document.addField("transactionAmount_stored_double", transactionAmount.doubleValue());
		}
		if(transactionDateTime != null) {
			document.addField("transactionDateTime_indexed_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(transactionDateTime.toInstant(), ZoneId.of("UTC"))));
			document.addField("transactionDateTime_stored_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(transactionDateTime.toInstant(), ZoneId.of("UTC"))));
		}
		if(transactionDate != null) {
			document.addField("transactionDate_indexed_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(transactionDate.atStartOfDay(ZoneId.systemDefault()).toInstant().atZone(ZoneId.of("Z"))));
			document.addField("transactionDate_stored_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(transactionDate.atStartOfDay(ZoneId.systemDefault()).toInstant().atZone(ZoneId.of("Z"))));
		}
		if(transactionFee != null) {
			document.addField("transactionFee_indexed_boolean", transactionFee);
			document.addField("transactionFee_stored_boolean", transactionFee);
		}
		if(agentAreas != null) {
			for(java.lang.String o : agentAreas) {
				document.addField("agentAreas_indexed_strings", o);
			}
			for(java.lang.String o : agentAreas) {
				document.addField("agentAreas_stored_strings", o);
			}
		}
		if(agentRoles != null) {
			for(java.lang.String o : agentRoles) {
				document.addField("agentRoles_indexed_strings", o);
			}
			for(java.lang.String o : agentRoles) {
				document.addField("agentRoles_stored_strings", o);
			}
		}
		if(agentOverride != null) {
			document.addField("agentOverride_indexed_boolean", agentOverride);
			document.addField("agentOverride_stored_boolean", agentOverride);
		}
		if(eligibleEntitlement != null) {
			document.addField("eligibleEntitlement_indexed_boolean", eligibleEntitlement);
			document.addField("eligibleEntitlement_stored_boolean", eligibleEntitlement);
		}
		if(partnerName != null) {
			document.addField("partnerName_indexed_string", partnerName);
			document.addField("partnerName_stored_string", partnerName);
		}
		if(adjustmentDisplayName != null) {
			document.addField("adjustmentDisplayName_indexed_string", adjustmentDisplayName);
			document.addField("adjustmentDisplayName_stored_string", adjustmentDisplayName);
		}
		if(adjustmentCompleteName != null) {
			document.addField("adjustmentCompleteName_indexed_string", adjustmentCompleteName);
			document.addField("adjustmentCompleteName_stored_string", adjustmentCompleteName);
		}
		if(adjustmentId != null) {
			document.addField("adjustmentId_indexed_string", adjustmentId);
			document.addField("adjustmentId_stored_string", adjustmentId);
		}
		if(pageUrl != null) {
			document.addField("pageUrl_indexed_string", pageUrl);
			document.addField("pageUrl_stored_string", pageUrl);
		}
		if(objectSuggest != null) {
			document.addField("objectSuggest_suggested", objectSuggest);
		}
		super.indexCluster(document);

	}

	public void unindexBankAdjustment() {
		try {
		SiteRequestEnUS siteRequest = new SiteRequestEnUS();
			siteRequest.initDeepSiteRequestEnUS();
			SiteContextEnUS siteContext = new SiteContextEnUS();
			siteContext.initDeepSiteContextEnUS();
			siteRequest.setSiteContext_(siteContext);
			siteRequest.setSiteConfig_(siteContext.getSiteConfig());
			initDeepBankAdjustment(siteRequest);
			SolrClient solrClient = siteContext.getSolrClient();
			solrClient.deleteById(id.toString());
			solrClient.commit(false, false, true);
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public static String varIndexedBankAdjustment(String entityVar) {
		switch(entityVar) {
			case "adjustmentKey":
				return "adjustmentKey_indexed_long";
			case "accountKey":
				return "accountKey_indexed_long";
			case "accountCompleteName":
				return "accountCompleteName_indexed_string";
			case "accountNumber":
				return "accountNumber_indexed_string";
			case "transactionKey":
				return "transactionKey_indexed_long";
			case "transactionReferenceId":
				return "transactionReferenceId_indexed_string";
			case "transactionCode":
				return "transactionCode_indexed_string";
			case "transactionAmount":
				return "transactionAmount_indexed_double";
			case "transactionDateTime":
				return "transactionDateTime_indexed_date";
			case "transactionDate":
				return "transactionDate_indexed_date";
			case "transactionFee":
				return "transactionFee_indexed_boolean";
			case "agentAreas":
				return "agentAreas_indexed_strings";
			case "agentRoles":
				return "agentRoles_indexed_strings";
			case "agentOverride":
				return "agentOverride_indexed_boolean";
			case "eligibleEntitlement":
				return "eligibleEntitlement_indexed_boolean";
			case "partnerName":
				return "partnerName_indexed_string";
			case "adjustmentDisplayName":
				return "adjustmentDisplayName_indexed_string";
			case "adjustmentCompleteName":
				return "adjustmentCompleteName_indexed_string";
			case "adjustmentId":
				return "adjustmentId_indexed_string";
			case "pageUrl":
				return "pageUrl_indexed_string";
			case "objectSuggest":
				return "objectSuggest_indexed_string";
			default:
				return Cluster.varIndexedCluster(entityVar);
		}
	}

	public static String varSearchBankAdjustment(String entityVar) {
		switch(entityVar) {
			case "objectSuggest":
				return "objectSuggest_suggested";
			default:
				return Cluster.varSearchCluster(entityVar);
		}
	}

	public static String varSuggestBankAdjustment(String entityVar) {
		switch(entityVar) {
			case "objectSuggest":
				return "objectSuggest_suggested";
			default:
				return Cluster.varSuggestCluster(entityVar);
		}
	}

	/////////////
	// store //
	/////////////

	@Override public void storeForClass(SolrDocument solrDocument) {
		storeBankAdjustment(solrDocument);
	}
	public void storeBankAdjustment(SolrDocument solrDocument) {
		BankAdjustment oBankAdjustment = (BankAdjustment)this;

		Long adjustmentKey = (Long)solrDocument.get("adjustmentKey_stored_long");
		if(adjustmentKey != null)
			oBankAdjustment.setAdjustmentKey(adjustmentKey);

		Long accountKey = (Long)solrDocument.get("accountKey_stored_long");
		if(accountKey != null)
			oBankAdjustment.setAccountKey(accountKey);

		String accountCompleteName = (String)solrDocument.get("accountCompleteName_stored_string");
		if(accountCompleteName != null)
			oBankAdjustment.setAccountCompleteName(accountCompleteName);

		String accountNumber = (String)solrDocument.get("accountNumber_stored_string");
		if(accountNumber != null)
			oBankAdjustment.setAccountNumber(accountNumber);

		Long transactionKey = (Long)solrDocument.get("transactionKey_stored_long");
		if(transactionKey != null)
			oBankAdjustment.setTransactionKey(transactionKey);

		String transactionReferenceId = (String)solrDocument.get("transactionReferenceId_stored_string");
		if(transactionReferenceId != null)
			oBankAdjustment.setTransactionReferenceId(transactionReferenceId);

		String transactionCode = (String)solrDocument.get("transactionCode_stored_string");
		if(transactionCode != null)
			oBankAdjustment.setTransactionCode(transactionCode);

		Double transactionAmount = (Double)solrDocument.get("transactionAmount_stored_double");
		if(transactionAmount != null)
			oBankAdjustment.setTransactionAmount(transactionAmount);

		Date transactionDateTime = (Date)solrDocument.get("transactionDateTime_stored_date");
		if(transactionDateTime != null)
			oBankAdjustment.setTransactionDateTime(transactionDateTime);

		Date transactionDate = (Date)solrDocument.get("transactionDate_stored_date");
		if(transactionDate != null)
			oBankAdjustment.setTransactionDate(transactionDate);

		Boolean transactionFee = (Boolean)solrDocument.get("transactionFee_stored_boolean");
		if(transactionFee != null)
			oBankAdjustment.setTransactionFee(transactionFee);

		List<String> agentAreas = (List<String>)solrDocument.get("agentAreas_stored_strings");
		if(agentAreas != null)
			oBankAdjustment.agentAreas.addAll(agentAreas);

		List<String> agentRoles = (List<String>)solrDocument.get("agentRoles_stored_strings");
		if(agentRoles != null)
			oBankAdjustment.agentRoles.addAll(agentRoles);

		Boolean agentOverride = (Boolean)solrDocument.get("agentOverride_stored_boolean");
		if(agentOverride != null)
			oBankAdjustment.setAgentOverride(agentOverride);

		Boolean eligibleEntitlement = (Boolean)solrDocument.get("eligibleEntitlement_stored_boolean");
		if(eligibleEntitlement != null)
			oBankAdjustment.setEligibleEntitlement(eligibleEntitlement);

		String partnerName = (String)solrDocument.get("partnerName_stored_string");
		if(partnerName != null)
			oBankAdjustment.setPartnerName(partnerName);

		String adjustmentDisplayName = (String)solrDocument.get("adjustmentDisplayName_stored_string");
		if(adjustmentDisplayName != null)
			oBankAdjustment.setAdjustmentDisplayName(adjustmentDisplayName);

		String adjustmentCompleteName = (String)solrDocument.get("adjustmentCompleteName_stored_string");
		if(adjustmentCompleteName != null)
			oBankAdjustment.setAdjustmentCompleteName(adjustmentCompleteName);

		String adjustmentId = (String)solrDocument.get("adjustmentId_stored_string");
		if(adjustmentId != null)
			oBankAdjustment.setAdjustmentId(adjustmentId);

		String pageUrl = (String)solrDocument.get("pageUrl_stored_string");
		if(pageUrl != null)
			oBankAdjustment.setPageUrl(pageUrl);

		String objectSuggest = (String)solrDocument.get("objectSuggest_suggested");
		oBankAdjustment.setObjectSuggest(objectSuggest);

		super.storeCluster(solrDocument);
	}

	//////////////////
	// patchRequest //
	//////////////////

	public void patchRequestBankAdjustment() {
		PatchRequest patchRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getPatchRequest_).orElse(null);
		BankAdjustment original = (BankAdjustment)Optional.ofNullable(patchRequest).map(PatchRequest::getOriginal).orElse(null);
		if(original != null) {
			if(!Objects.equals(agentAreas, original.getAgentAreas()))
				patchRequest.addVars("agentAreas");
			if(!Objects.equals(agentRoles, original.getAgentRoles()))
				patchRequest.addVars("agentRoles");
			if(!Objects.equals(agentOverride, original.getAgentOverride()))
				patchRequest.addVars("agentOverride");
			if(!Objects.equals(eligibleEntitlement, original.getEligibleEntitlement()))
				patchRequest.addVars("eligibleEntitlement");
			if(!Objects.equals(partnerName, original.getPartnerName()))
				patchRequest.addVars("partnerName");
			if(!Objects.equals(adjustmentDisplayName, original.getAdjustmentDisplayName()))
				patchRequest.addVars("adjustmentDisplayName");
			super.patchRequestCluster();
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(super.hashCode(), agentAreas, agentRoles, agentOverride, eligibleEntitlement, partnerName, adjustmentDisplayName);
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof BankAdjustment))
			return false;
		BankAdjustment that = (BankAdjustment)o;
		return super.equals(o)
				&& Objects.equals( agentAreas, that.agentAreas )
				&& Objects.equals( agentRoles, that.agentRoles )
				&& Objects.equals( agentOverride, that.agentOverride )
				&& Objects.equals( eligibleEntitlement, that.eligibleEntitlement )
				&& Objects.equals( partnerName, that.partnerName )
				&& Objects.equals( adjustmentDisplayName, that.adjustmentDisplayName );
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("BankAdjustment { ");
		sb.append( "agentAreas: " ).append(agentAreas);
		sb.append( ", agentRoles: " ).append(agentRoles);
		sb.append( ", agentOverride: " ).append(agentOverride);
		sb.append( ", eligibleEntitlement: " ).append(eligibleEntitlement);
		sb.append( ", partnerName: \"" ).append(partnerName).append( "\"" );
		sb.append( ", adjustmentDisplayName: \"" ).append(adjustmentDisplayName).append( "\"" );
		sb.append(" }");
		return sb.toString();
	}
}
