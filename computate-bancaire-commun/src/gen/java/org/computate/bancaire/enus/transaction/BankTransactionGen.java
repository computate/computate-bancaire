package org.computate.bancaire.enus.transaction;

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
import org.computate.bancaire.enus.transaction.code.TransactionCode;
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
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.BankTransaction&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class BankTransactionGen<DEV> extends Cluster {
	private static final Logger LOGGER = LoggerFactory.getLogger(BankTransaction.class);

	public static final String BankTransaction_UnNom = "a transaction";
	public static final String BankTransaction_Ce = "this ";
	public static final String BankTransaction_CeNom = "this transaction";
	public static final String BankTransaction_Un = "a ";
	public static final String BankTransaction_LeNom = "the transaction";
	public static final String BankTransaction_NomSingulier = "transaction";
	public static final String BankTransaction_NomPluriel = "transactions";
	public static final String BankTransaction_NomActuel = "current transaction";
	public static final String BankTransaction_TousNom = "all the transactions";
	public static final String BankTransaction_RechercherTousNomPar = "search transactions by ";
	public static final String BankTransaction_LesNoms = "the transactions";
	public static final String BankTransaction_AucunNomTrouve = "no transaction found";
	public static final String BankTransaction_NomVar = "transaction";
	public static final String BankTransaction_DeNom = "of transaction";
	public static final String BankTransaction_UnNomAdjectif = "a transaction";
	public static final String BankTransaction_NomAdjectifSingulier = "transaction";
	public static final String BankTransaction_NomAdjectifPluriel = "transactions";
	public static final String BankTransaction_Couleur = "yellow";
	public static final String BankTransaction_IconeGroupe = "duotone";
	public static final String BankTransaction_IconeNom = "cash-register";

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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.BankTransaction&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:transactionKey">Trouver l'entité transactionKey dans Solr</a>
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
	public BankTransaction setTransactionKey(String o) {
		if(NumberUtils.isParsable(o))
			this.transactionKey = Long.parseLong(o);
		this.transactionKeyWrap.alreadyInitialized = true;
		return (BankTransaction)this;
	}
	protected BankTransaction transactionKeyInit() {
		if(!transactionKeyWrap.alreadyInitialized) {
			_transactionKey(transactionKeyWrap);
			if(transactionKey == null)
				setTransactionKey(transactionKeyWrap.o);
		}
		transactionKeyWrap.alreadyInitialized(true);
		return (BankTransaction)this;
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
		return "key";
	}

	public String htmTooltipTransactionKey() {
		return null;
	}

	public String htmTransactionKey() {
		return transactionKey == null ? "" : StringEscapeUtils.escapeHtml4(strTransactionKey());
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.BankTransaction&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:accountKey">Trouver l'entité accountKey dans Solr</a>
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
	public BankTransaction setAccountKey(String o) {
		if(NumberUtils.isParsable(o))
			this.accountKey = Long.parseLong(o);
		this.accountKeyWrap.alreadyInitialized = true;
		return (BankTransaction)this;
	}
	protected BankTransaction accountKeyInit() {
		if(!accountKeyWrap.alreadyInitialized) {
			_accountKey(accountKeyWrap);
			if(accountKey == null)
				setAccountKey(accountKeyWrap.o);
		}
		accountKeyWrap.alreadyInitialized(true);
		return (BankTransaction)this;
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
		BankTransaction s = (BankTransaction)this;
		e("i").a("class", "far fa-search w3-xxlarge w3-cell w3-cell-middle ").f().g("i");
			e("input")
				.a("type", "text")
				.a("placeholder", "account")
				.a("class", "value suggestAccountKey w3-input w3-border w3-cell w3-cell-middle ")
				.a("name", "setAccountKey")
				.a("id", classApiMethodMethod, "_accountKey")
				.a("autocomplete", "off")
				.a("oninput", "suggestBankTransactionAccountKey($(this).val() ? searchBankAccountFilters($('#suggestBankTransactionAccountKey')) : [{'name':'fq','value':'yearKeys:", pk, "'}], $('#listBankTransactionAccountKey_", classApiMethodMethod, "'), ", pk, "); ")
			.fg();

	}

	public void htmAccountKey(String classApiMethodMethod) {
		BankTransaction s = (BankTransaction)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestBankTransactionAccountKey").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row ").f();
							{ e("a").a("href", "").a("class", "w3-cell w3-btn w3-center h4 w3-block h4 w3-gray w3-hover-gray ").f();
								e("i").a("class", "fad fa-money-check w3-padding-small ").f().g("i");
								sx("account");
							} g("a");
						} g("div");
						{ e("div").a("class", "w3-cell-row ").f();
							{ e("h5").a("class", "w3-cell ").f();
								sx("relate an account to this transaction");
							} g("h5");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-cell-row ").f();

								inputAccountKey(classApiMethodMethod);
								} g("div");
							} g("div");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
								{ e("ul").a("class", "w3-ul w3-hoverable ").a("id", "listBankTransactionAccountKey_", classApiMethodMethod).f();
								} g("ul");
								{ e("div").a("class", "w3-cell-row ").f();
									e("button")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-gray ")
										.a("onclick", "postBankAccountVals({ yearKeys: \"", pk, "\" }, function() { patchBankTransactionVals([{ name: 'fq', value: 'pk:", pk, "' }], {}); }, function() { addError($('#", classApiMethodMethod, "accountKey')); });")
										.f().sx("add an account")
									.g("button");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.BankTransaction&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:accountSearch">Trouver l'entité accountSearch dans Solr</a>
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
	protected BankTransaction accountSearchInit() {
		if(!accountSearchWrap.alreadyInitialized) {
			_accountSearch(accountSearch);
		}
		accountSearch.initDeepForClass(siteRequest_);
		accountSearchWrap.alreadyInitialized(true);
		return (BankTransaction)this;
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.BankTransaction&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:account_">Trouver l'entité account_ dans Solr</a>
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
	protected BankTransaction account_Init() {
		if(!account_Wrap.alreadyInitialized) {
			_account_(account_Wrap);
			if(account_ == null)
				setAccount_(account_Wrap.o);
		}
		account_Wrap.alreadyInitialized(true);
		return (BankTransaction)this;
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.BankTransaction&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:accountCompleteName">Trouver l'entité accountCompleteName dans Solr</a>
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
	protected BankTransaction accountCompleteNameInit() {
		if(!accountCompleteNameWrap.alreadyInitialized) {
			_accountCompleteName(accountCompleteNameWrap);
			if(accountCompleteName == null)
				setAccountCompleteName(accountCompleteNameWrap.o);
		}
		accountCompleteNameWrap.alreadyInitialized(true);
		return (BankTransaction)this;
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.BankTransaction&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:accountNumber">Trouver l'entité accountNumber dans Solr</a>
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
	protected BankTransaction accountNumberInit() {
		if(!accountNumberWrap.alreadyInitialized) {
			_accountNumber(accountNumberWrap);
			if(accountNumber == null)
				setAccountNumber(accountNumberWrap.o);
		}
		accountNumberWrap.alreadyInitialized(true);
		return (BankTransaction)this;
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.BankTransaction&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:transactionCode">Trouver l'entité transactionCode dans Solr</a>
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
	protected BankTransaction transactionCodeInit() {
		if(!transactionCodeWrap.alreadyInitialized) {
			_transactionCode(transactionCodeWrap);
			if(transactionCode == null)
				setTransactionCode(transactionCodeWrap.o);
		}
		transactionCodeWrap.alreadyInitialized(true);
		return (BankTransaction)this;
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
		return "transaction code";
	}

	public String htmTooltipTransactionCode() {
		return null;
	}

	public String htmTransactionCode() {
		return transactionCode == null ? "" : StringEscapeUtils.escapeHtml4(strTransactionCode());
	}

	public void inputTransactionCode(String classApiMethodMethod) {
		BankTransaction s = (BankTransaction)this;
		e("input")
			.a("type", "text")
			.a("placeholder", "transaction code")
			.a("id", classApiMethodMethod, "_transactionCode");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setTransactionCode inputBankTransaction", pk, "TransactionCode w3-input w3-border ");
				a("name", "setTransactionCode");
			} else {
				a("class", "valueTransactionCode w3-input w3-border inputBankTransaction", pk, "TransactionCode w3-input w3-border ");
				a("name", "transactionCode");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchBankTransactionVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setTransactionCode', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_transactionCode')); }, function() { addError($('#", classApiMethodMethod, "_transactionCode')); }); ");
			}
			a("value", strTransactionCode())
		.fg();

	}

	public void htmTransactionCode(String classApiMethodMethod) {
		BankTransaction s = (BankTransaction)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestBankTransactionTransactionCode").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_transactionCode").a("class", "").f().sx("transaction code").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputTransactionCode(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_transactionCode')); $('#", classApiMethodMethod, "_transactionCode').val(null); patchBankTransactionVal([{ name: 'fq', value: 'pk:' + $('#BankTransactionForm :input[name=pk]').val() }], 'setTransactionCode', null, function() { addGlow($('#", classApiMethodMethod, "_transactionCode')); }, function() { addError($('#", classApiMethodMethod, "_transactionCode')); }); ")
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
	// transactionCodeSearch //
	///////////////////////////

	/**	L'entité « transactionCodeSearch »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut SearchList<TransactionCode>(). 
	 */
	@JsonIgnore
	protected SearchList<TransactionCode> transactionCodeSearch = new SearchList<TransactionCode>();
	@JsonIgnore
	public Wrap<SearchList<TransactionCode>> transactionCodeSearchWrap = new Wrap<SearchList<TransactionCode>>().p(this).c(SearchList.class).var("transactionCodeSearch").o(transactionCodeSearch);

	/**	<br/>L'entité « transactionCodeSearch »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut SearchList<TransactionCode>(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.BankTransaction&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:transactionCodeSearch">Trouver l'entité transactionCodeSearch dans Solr</a>
	 * <br/>
	 * @param transactionCodeSearch est l'entité déjà construit. 
	 **/
	protected abstract void _transactionCodeSearch(SearchList<TransactionCode> l);

	public SearchList<TransactionCode> getTransactionCodeSearch() {
		return transactionCodeSearch;
	}

	public void setTransactionCodeSearch(SearchList<TransactionCode> transactionCodeSearch) {
		this.transactionCodeSearch = transactionCodeSearch;
		this.transactionCodeSearchWrap.alreadyInitialized = true;
	}
	protected BankTransaction transactionCodeSearchInit() {
		if(!transactionCodeSearchWrap.alreadyInitialized) {
			_transactionCodeSearch(transactionCodeSearch);
		}
		transactionCodeSearch.initDeepForClass(siteRequest_);
		transactionCodeSearchWrap.alreadyInitialized(true);
		return (BankTransaction)this;
	}

	////////////////////////////
	// transactionCodeObject_ //
	////////////////////////////

	/**	L'entité « transactionCodeObject_ »
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	protected TransactionCode transactionCodeObject_;
	@JsonIgnore
	public Wrap<TransactionCode> transactionCodeObject_Wrap = new Wrap<TransactionCode>().p(this).c(TransactionCode.class).var("transactionCodeObject_").o(transactionCodeObject_);

	/**	<br/>L'entité « transactionCodeObject_ »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.BankTransaction&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:transactionCodeObject_">Trouver l'entité transactionCodeObject_ dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _transactionCodeObject_(Wrap<TransactionCode> c);

	public TransactionCode getTransactionCodeObject_() {
		return transactionCodeObject_;
	}

	public void setTransactionCodeObject_(TransactionCode transactionCodeObject_) {
		this.transactionCodeObject_ = transactionCodeObject_;
		this.transactionCodeObject_Wrap.alreadyInitialized = true;
	}
	protected BankTransaction transactionCodeObject_Init() {
		if(!transactionCodeObject_Wrap.alreadyInitialized) {
			_transactionCodeObject_(transactionCodeObject_Wrap);
			if(transactionCodeObject_ == null)
				setTransactionCodeObject_(transactionCodeObject_Wrap.o);
		}
		transactionCodeObject_Wrap.alreadyInitialized(true);
		return (BankTransaction)this;
	}

	/////////////////////////////////
	// transactionCodeCompleteName //
	/////////////////////////////////

	/**	L'entité « transactionCodeCompleteName »
	 *	 is defined as null before being initialized. 
	 */
	protected String transactionCodeCompleteName;
	@JsonIgnore
	public Wrap<String> transactionCodeCompleteNameWrap = new Wrap<String>().p(this).c(String.class).var("transactionCodeCompleteName").o(transactionCodeCompleteName);

	/**	<br/>L'entité « transactionCodeCompleteName »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.BankTransaction&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:transactionCodeCompleteName">Trouver l'entité transactionCodeCompleteName dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _transactionCodeCompleteName(Wrap<String> c);

	public String getTransactionCodeCompleteName() {
		return transactionCodeCompleteName;
	}

	public void setTransactionCodeCompleteName(String transactionCodeCompleteName) {
		this.transactionCodeCompleteName = transactionCodeCompleteName;
		this.transactionCodeCompleteNameWrap.alreadyInitialized = true;
	}
	protected BankTransaction transactionCodeCompleteNameInit() {
		if(!transactionCodeCompleteNameWrap.alreadyInitialized) {
			_transactionCodeCompleteName(transactionCodeCompleteNameWrap);
			if(transactionCodeCompleteName == null)
				setTransactionCodeCompleteName(transactionCodeCompleteNameWrap.o);
		}
		transactionCodeCompleteNameWrap.alreadyInitialized(true);
		return (BankTransaction)this;
	}

	public String solrTransactionCodeCompleteName() {
		return transactionCodeCompleteName;
	}

	public String strTransactionCodeCompleteName() {
		return transactionCodeCompleteName == null ? "" : transactionCodeCompleteName;
	}

	public String jsonTransactionCodeCompleteName() {
		return transactionCodeCompleteName == null ? "" : transactionCodeCompleteName;
	}

	public String nomAffichageTransactionCodeCompleteName() {
		return null;
	}

	public String htmTooltipTransactionCodeCompleteName() {
		return null;
	}

	public String htmTransactionCodeCompleteName() {
		return transactionCodeCompleteName == null ? "" : StringEscapeUtils.escapeHtml4(strTransactionCodeCompleteName());
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.BankTransaction&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:transactionReferenceId">Trouver l'entité transactionReferenceId dans Solr</a>
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
	protected BankTransaction transactionReferenceIdInit() {
		if(!transactionReferenceIdWrap.alreadyInitialized) {
			_transactionReferenceId(transactionReferenceIdWrap);
			if(transactionReferenceId == null)
				setTransactionReferenceId(transactionReferenceIdWrap.o);
		}
		transactionReferenceIdWrap.alreadyInitialized(true);
		return (BankTransaction)this;
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

	public void inputTransactionReferenceId(String classApiMethodMethod) {
		BankTransaction s = (BankTransaction)this;
		e("input")
			.a("type", "text")
			.a("placeholder", "transaction reference ID")
			.a("id", classApiMethodMethod, "_transactionReferenceId");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setTransactionReferenceId inputBankTransaction", pk, "TransactionReferenceId w3-input w3-border ");
				a("name", "setTransactionReferenceId");
			} else {
				a("class", "valueTransactionReferenceId w3-input w3-border inputBankTransaction", pk, "TransactionReferenceId w3-input w3-border ");
				a("name", "transactionReferenceId");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchBankTransactionVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setTransactionReferenceId', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_transactionReferenceId')); }, function() { addError($('#", classApiMethodMethod, "_transactionReferenceId')); }); ");
			}
			a("value", strTransactionReferenceId())
		.fg();

	}

	public void htmTransactionReferenceId(String classApiMethodMethod) {
		BankTransaction s = (BankTransaction)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestBankTransactionTransactionReferenceId").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_transactionReferenceId").a("class", "").f().sx("transaction reference ID").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputTransactionReferenceId(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_transactionReferenceId')); $('#", classApiMethodMethod, "_transactionReferenceId').val(null); patchBankTransactionVal([{ name: 'fq', value: 'pk:' + $('#BankTransactionForm :input[name=pk]').val() }], 'setTransactionReferenceId', null, function() { addGlow($('#", classApiMethodMethod, "_transactionReferenceId')); }, function() { addError($('#", classApiMethodMethod, "_transactionReferenceId')); }); ")
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.BankTransaction&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:transactionAmount">Trouver l'entité transactionAmount dans Solr</a>
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
	public BankTransaction setTransactionAmount(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.transactionAmount = new BigDecimal(o, MathContext.DECIMAL64).setScale(2);
		this.transactionAmountWrap.alreadyInitialized = true;
		return (BankTransaction)this;
	}
	public BankTransaction setTransactionAmount(Double o) {
			this.transactionAmount = new BigDecimal(o, MathContext.DECIMAL64).setScale(2);
		this.transactionAmountWrap.alreadyInitialized = true;
		return (BankTransaction)this;
	}
	public BankTransaction setTransactionAmount(Integer o) {
			this.transactionAmount = new BigDecimal(o, MathContext.DECIMAL64).setScale(2);
		this.transactionAmountWrap.alreadyInitialized = true;
		return (BankTransaction)this;
	}
	protected BankTransaction transactionAmountInit() {
		if(!transactionAmountWrap.alreadyInitialized) {
			_transactionAmount(transactionAmountWrap);
			if(transactionAmount == null)
				setTransactionAmount(transactionAmountWrap.o);
		}
		transactionAmountWrap.alreadyInitialized(true);
		return (BankTransaction)this;
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

	public void inputTransactionAmount(String classApiMethodMethod) {
		BankTransaction s = (BankTransaction)this;
		e("input")
			.a("type", "text")
			.a("placeholder", "date and time of the transaction")
			.a("id", classApiMethodMethod, "_transactionAmount");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setTransactionAmount inputBankTransaction", pk, "TransactionAmount w3-input w3-border ");
				a("name", "setTransactionAmount");
			} else {
				a("class", "valueTransactionAmount w3-input w3-border inputBankTransaction", pk, "TransactionAmount w3-input w3-border ");
				a("name", "transactionAmount");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchBankTransactionVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setTransactionAmount', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_transactionAmount')); }, function() { addError($('#", classApiMethodMethod, "_transactionAmount')); }); ");
			}
			a("value", strTransactionAmount())
		.fg();

	}

	public void htmTransactionAmount(String classApiMethodMethod) {
		BankTransaction s = (BankTransaction)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestBankTransactionTransactionAmount").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_transactionAmount").a("class", "").f().sx("date and time of the transaction").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputTransactionAmount(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_transactionAmount')); $('#", classApiMethodMethod, "_transactionAmount').val(null); patchBankTransactionVal([{ name: 'fq', value: 'pk:' + $('#BankTransactionForm :input[name=pk]').val() }], 'setTransactionAmount', null, function() { addGlow($('#", classApiMethodMethod, "_transactionAmount')); }, function() { addError($('#", classApiMethodMethod, "_transactionAmount')); }); ")
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.BankTransaction&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:transactionDateTime">Trouver l'entité transactionDateTime dans Solr</a>
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
	public BankTransaction setTransactionDateTime(Instant o) {
		this.transactionDateTime = ZonedDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
		this.transactionDateTimeWrap.alreadyInitialized = true;
		return (BankTransaction)this;
	}
	/** Example: 2011-12-03T10:15:30+01:00 **/
	public BankTransaction setTransactionDateTime(String o) {
		this.transactionDateTime = ZonedDateTime.parse(o, DateTimeFormatter.ISO_OFFSET_DATE_TIME.withZone(ZoneId.of(siteRequest_.getSiteConfig_().getSiteZone()))).truncatedTo(ChronoUnit.MILLIS);
		this.transactionDateTimeWrap.alreadyInitialized = true;
		return (BankTransaction)this;
	}
	public BankTransaction setTransactionDateTime(Date o) {
		this.transactionDateTime = ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getSiteConfig_().getSiteZone())).truncatedTo(ChronoUnit.MILLIS);
		this.transactionDateTimeWrap.alreadyInitialized = true;
		return (BankTransaction)this;
	}
	protected BankTransaction transactionDateTimeInit() {
		if(!transactionDateTimeWrap.alreadyInitialized) {
			_transactionDateTime(transactionDateTimeWrap);
			if(transactionDateTime == null)
				setTransactionDateTime(transactionDateTimeWrap.o);
		}
		transactionDateTimeWrap.alreadyInitialized(true);
		return (BankTransaction)this;
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

	public void inputTransactionDateTime(String classApiMethodMethod) {
		BankTransaction s = (BankTransaction)this;
		e("input")
			.a("type", "text")
			.a("class", "w3-input w3-border datepicker setTransactionDateTime inputBankTransaction", pk, "TransactionDateTime w3-input w3-border ")
			.a("placeholder", "MM/DD/YYYY")
			.a("data-timeformat", "MM/DD/YYYY")
			.a("id", classApiMethodMethod, "_transactionDateTime")
			.a("onclick", "removeGlow($(this)); ")
			.a("value", transactionDateTime == null ? "" : DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.forLanguageTag("en-US")).format(transactionDateTime))
			.a("onchange", "var t = moment(this.value, 'MM/DD/YYYY'); if(t) { var s = t.format('MM/DD/YYYY'); patchBankTransactionVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setTransactionDateTime', s, function() { addGlow($('#", classApiMethodMethod, "_transactionDateTime')); }, function() { addError($('#", classApiMethodMethod, "_transactionDateTime')); }); } ")
			.fg();
	}

	public void htmTransactionDateTime(String classApiMethodMethod) {
		BankTransaction s = (BankTransaction)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestBankTransactionTransactionDateTime").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_transactionDateTime").a("class", "").f().sx("date and time of the transaction").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();
								inputTransactionDateTime(classApiMethodMethod);
									} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_transactionDateTime')); $('#", classApiMethodMethod, "_transactionDateTime').val(null); patchBankTransactionVal([{ name: 'fq', value: 'pk:' + $('#BankTransactionForm :input[name=pk]').val() }], 'setTransactionDateTime', null, function() { addGlow($('#", classApiMethodMethod, "_transactionDateTime')); }, function() { addError($('#", classApiMethodMethod, "_transactionDateTime')); }); ")
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.BankTransaction&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:transactionDate">Trouver l'entité transactionDate dans Solr</a>
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
	public BankTransaction setTransactionDate(Instant o) {
		this.transactionDate = LocalDate.from(o);
		this.transactionDateWrap.alreadyInitialized = true;
		return (BankTransaction)this;
	}
	/** Example: 2011-12-03+01:00 **/
	public BankTransaction setTransactionDate(String o) {
		this.transactionDate = LocalDate.parse(o, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		this.transactionDateWrap.alreadyInitialized = true;
		return (BankTransaction)this;
	}
	public BankTransaction setTransactionDate(Date o) {
		this.transactionDate = o.toInstant().atZone(ZoneId.of(siteRequest_.getSiteConfig_().getSiteZone())).toLocalDate();
		this.transactionDateWrap.alreadyInitialized = true;
		return (BankTransaction)this;
	}
	protected BankTransaction transactionDateInit() {
		if(!transactionDateWrap.alreadyInitialized) {
			_transactionDate(transactionDateWrap);
			if(transactionDate == null)
				setTransactionDate(transactionDateWrap.o);
		}
		transactionDateWrap.alreadyInitialized(true);
		return (BankTransaction)this;
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.BankTransaction&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:transactionFee">Trouver l'entité transactionFee dans Solr</a>
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
	public BankTransaction setTransactionFee(String o) {
		this.transactionFee = Boolean.parseBoolean(o);
		this.transactionFeeWrap.alreadyInitialized = true;
		return (BankTransaction)this;
	}
	protected BankTransaction transactionFeeInit() {
		if(!transactionFeeWrap.alreadyInitialized) {
			_transactionFee(transactionFeeWrap);
			if(transactionFee == null)
				setTransactionFee(transactionFeeWrap.o);
		}
		transactionFeeWrap.alreadyInitialized(true);
		return (BankTransaction)this;
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

	public void inputTransactionFee(String classApiMethodMethod) {
		BankTransaction s = (BankTransaction)this;
		e("input")
			.a("type", "checkbox")
			.a("id", classApiMethodMethod, "_transactionFee")
			.a("value", "true");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setTransactionFee inputBankTransaction", pk, "TransactionFee w3-input w3-border ");
				a("name", "setTransactionFee");
			} else {
				a("class", "valueTransactionFee inputBankTransaction", pk, "TransactionFee w3-input w3-border ");
				a("name", "transactionFee");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onchange", "patchBankTransactionVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setTransactionFee', $(this).prop('checked'), function() { addGlow($('#", classApiMethodMethod, "_transactionFee')); }, function() { addError($('#", classApiMethodMethod, "_transactionFee')); }); ");
			}
			;
			if(getTransactionFee() != null && getTransactionFee())
				a("checked", "checked");
		fg();

	}

	public void htmTransactionFee(String classApiMethodMethod) {
		BankTransaction s = (BankTransaction)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestBankTransactionTransactionFee").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_transactionFee").a("class", "").f().sx("fee transaction").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputTransactionFee(classApiMethodMethod);
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	////////////////////////////
	// transactionDisplayName //
	////////////////////////////

	/**	L'entité « transactionDisplayName »
	 *	 is defined as null before being initialized. 
	 */
	protected String transactionDisplayName;
	@JsonIgnore
	public Wrap<String> transactionDisplayNameWrap = new Wrap<String>().p(this).c(String.class).var("transactionDisplayName").o(transactionDisplayName);

	/**	<br/>L'entité « transactionDisplayName »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.BankTransaction&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:transactionDisplayName">Trouver l'entité transactionDisplayName dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _transactionDisplayName(Wrap<String> c);

	public String getTransactionDisplayName() {
		return transactionDisplayName;
	}

	public void setTransactionDisplayName(String transactionDisplayName) {
		this.transactionDisplayName = transactionDisplayName;
		this.transactionDisplayNameWrap.alreadyInitialized = true;
	}
	protected BankTransaction transactionDisplayNameInit() {
		if(!transactionDisplayNameWrap.alreadyInitialized) {
			_transactionDisplayName(transactionDisplayNameWrap);
			if(transactionDisplayName == null)
				setTransactionDisplayName(transactionDisplayNameWrap.o);
		}
		transactionDisplayNameWrap.alreadyInitialized(true);
		return (BankTransaction)this;
	}

	public String solrTransactionDisplayName() {
		return transactionDisplayName;
	}

	public String strTransactionDisplayName() {
		return transactionDisplayName == null ? "" : transactionDisplayName;
	}

	public String jsonTransactionDisplayName() {
		return transactionDisplayName == null ? "" : transactionDisplayName;
	}

	public String nomAffichageTransactionDisplayName() {
		return "display name";
	}

	public String htmTooltipTransactionDisplayName() {
		return null;
	}

	public String htmTransactionDisplayName() {
		return transactionDisplayName == null ? "" : StringEscapeUtils.escapeHtml4(strTransactionDisplayName());
	}

	public void inputTransactionDisplayName(String classApiMethodMethod) {
		BankTransaction s = (BankTransaction)this;
		e("input")
			.a("type", "text")
			.a("placeholder", "display name")
			.a("id", classApiMethodMethod, "_transactionDisplayName");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setTransactionDisplayName inputBankTransaction", pk, "TransactionDisplayName w3-input w3-border ");
				a("name", "setTransactionDisplayName");
			} else {
				a("class", "valueTransactionDisplayName w3-input w3-border inputBankTransaction", pk, "TransactionDisplayName w3-input w3-border ");
				a("name", "transactionDisplayName");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchBankTransactionVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setTransactionDisplayName', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_transactionDisplayName')); }, function() { addError($('#", classApiMethodMethod, "_transactionDisplayName')); }); ");
			}
			a("value", strTransactionDisplayName())
		.fg();

	}

	public void htmTransactionDisplayName(String classApiMethodMethod) {
		BankTransaction s = (BankTransaction)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestBankTransactionTransactionDisplayName").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_transactionDisplayName").a("class", "").f().sx("display name").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputTransactionDisplayName(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_transactionDisplayName')); $('#", classApiMethodMethod, "_transactionDisplayName').val(null); patchBankTransactionVal([{ name: 'fq', value: 'pk:' + $('#BankTransactionForm :input[name=pk]').val() }], 'setTransactionDisplayName', null, function() { addGlow($('#", classApiMethodMethod, "_transactionDisplayName')); }, function() { addError($('#", classApiMethodMethod, "_transactionDisplayName')); }); ")
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

	/////////////////////////////
	// transactionCompleteName //
	/////////////////////////////

	/**	L'entité « transactionCompleteName »
	 *	 is defined as null before being initialized. 
	 */
	protected String transactionCompleteName;
	@JsonIgnore
	public Wrap<String> transactionCompleteNameWrap = new Wrap<String>().p(this).c(String.class).var("transactionCompleteName").o(transactionCompleteName);

	/**	<br/>L'entité « transactionCompleteName »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.BankTransaction&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:transactionCompleteName">Trouver l'entité transactionCompleteName dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _transactionCompleteName(Wrap<String> c);

	public String getTransactionCompleteName() {
		return transactionCompleteName;
	}

	public void setTransactionCompleteName(String transactionCompleteName) {
		this.transactionCompleteName = transactionCompleteName;
		this.transactionCompleteNameWrap.alreadyInitialized = true;
	}
	protected BankTransaction transactionCompleteNameInit() {
		if(!transactionCompleteNameWrap.alreadyInitialized) {
			_transactionCompleteName(transactionCompleteNameWrap);
			if(transactionCompleteName == null)
				setTransactionCompleteName(transactionCompleteNameWrap.o);
		}
		transactionCompleteNameWrap.alreadyInitialized(true);
		return (BankTransaction)this;
	}

	public String solrTransactionCompleteName() {
		return transactionCompleteName;
	}

	public String strTransactionCompleteName() {
		return transactionCompleteName == null ? "" : transactionCompleteName;
	}

	public String jsonTransactionCompleteName() {
		return transactionCompleteName == null ? "" : transactionCompleteName;
	}

	public String nomAffichageTransactionCompleteName() {
		return null;
	}

	public String htmTooltipTransactionCompleteName() {
		return null;
	}

	public String htmTransactionCompleteName() {
		return transactionCompleteName == null ? "" : StringEscapeUtils.escapeHtml4(strTransactionCompleteName());
	}

	public void inputTransactionCompleteName(String classApiMethodMethod) {
		BankTransaction s = (BankTransaction)this;
	}

	public void htmTransactionCompleteName(String classApiMethodMethod) {
		BankTransaction s = (BankTransaction)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").f().sx(strTransactionCompleteName()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	///////////////////
	// transactionId //
	///////////////////

	/**	L'entité « transactionId »
	 *	 is defined as null before being initialized. 
	 */
	protected String transactionId;
	@JsonIgnore
	public Wrap<String> transactionIdWrap = new Wrap<String>().p(this).c(String.class).var("transactionId").o(transactionId);

	/**	<br/>L'entité « transactionId »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.BankTransaction&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:transactionId">Trouver l'entité transactionId dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _transactionId(Wrap<String> c);

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
		this.transactionIdWrap.alreadyInitialized = true;
	}
	protected BankTransaction transactionIdInit() {
		if(!transactionIdWrap.alreadyInitialized) {
			_transactionId(transactionIdWrap);
			if(transactionId == null)
				setTransactionId(transactionIdWrap.o);
		}
		transactionIdWrap.alreadyInitialized(true);
		return (BankTransaction)this;
	}

	public String solrTransactionId() {
		return transactionId;
	}

	public String strTransactionId() {
		return transactionId == null ? "" : transactionId;
	}

	public String jsonTransactionId() {
		return transactionId == null ? "" : transactionId;
	}

	public String nomAffichageTransactionId() {
		return "ID";
	}

	public String htmTooltipTransactionId() {
		return null;
	}

	public String htmTransactionId() {
		return transactionId == null ? "" : StringEscapeUtils.escapeHtml4(strTransactionId());
	}

	public void inputTransactionId(String classApiMethodMethod) {
		BankTransaction s = (BankTransaction)this;
	}

	public void htmTransactionId(String classApiMethodMethod) {
		BankTransaction s = (BankTransaction)this;
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
									e("span").f().sx(strTransactionId()).g("span");
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.BankTransaction&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageUrl">Trouver l'entité pageUrl dans Solr</a>
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
	protected BankTransaction pageUrlInit() {
		if(!pageUrlWrap.alreadyInitialized) {
			_pageUrl(pageUrlWrap);
			if(pageUrl == null)
				setPageUrl(pageUrlWrap.o);
		}
		pageUrlWrap.alreadyInitialized(true);
		return (BankTransaction)this;
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.BankTransaction&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:objectSuggest">Trouver l'entité objectSuggest dans Solr</a>
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
	protected BankTransaction objectSuggestInit() {
		if(!objectSuggestWrap.alreadyInitialized) {
			_objectSuggest(objectSuggestWrap);
			if(objectSuggest == null)
				setObjectSuggest(objectSuggestWrap.o);
		}
		objectSuggestWrap.alreadyInitialized(true);
		return (BankTransaction)this;
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

	protected boolean alreadyInitializedBankTransaction = false;

	public BankTransaction initDeepBankTransaction(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedBankTransaction) {
			alreadyInitializedBankTransaction = true;
			initDeepBankTransaction();
		}
		return (BankTransaction)this;
	}

	public void initDeepBankTransaction() {
		initBankTransaction();
		super.initDeepCluster(siteRequest_);
	}

	public void initBankTransaction() {
		transactionKeyInit();
		accountKeyInit();
		accountSearchInit();
		account_Init();
		accountCompleteNameInit();
		accountNumberInit();
		transactionCodeInit();
		transactionCodeSearchInit();
		transactionCodeObject_Init();
		transactionCodeCompleteNameInit();
		transactionReferenceIdInit();
		transactionAmountInit();
		transactionDateTimeInit();
		transactionDateInit();
		transactionFeeInit();
		transactionDisplayNameInit();
		transactionCompleteNameInit();
		transactionIdInit();
		pageUrlInit();
		objectSuggestInit();
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepBankTransaction(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestBankTransaction(SiteRequestEnUS siteRequest_) {
			super.siteRequestCluster(siteRequest_);
		if(accountSearch != null)
			accountSearch.setSiteRequest_(siteRequest_);
		if(transactionCodeSearch != null)
			transactionCodeSearch.setSiteRequest_(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestBankTransaction(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainBankTransaction(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainBankTransaction(String var) {
		BankTransaction oBankTransaction = (BankTransaction)this;
		switch(var) {
			case "transactionKey":
				return oBankTransaction.transactionKey;
			case "accountKey":
				return oBankTransaction.accountKey;
			case "accountSearch":
				return oBankTransaction.accountSearch;
			case "account_":
				return oBankTransaction.account_;
			case "accountCompleteName":
				return oBankTransaction.accountCompleteName;
			case "accountNumber":
				return oBankTransaction.accountNumber;
			case "transactionCode":
				return oBankTransaction.transactionCode;
			case "transactionCodeSearch":
				return oBankTransaction.transactionCodeSearch;
			case "transactionCodeObject_":
				return oBankTransaction.transactionCodeObject_;
			case "transactionCodeCompleteName":
				return oBankTransaction.transactionCodeCompleteName;
			case "transactionReferenceId":
				return oBankTransaction.transactionReferenceId;
			case "transactionAmount":
				return oBankTransaction.transactionAmount;
			case "transactionDateTime":
				return oBankTransaction.transactionDateTime;
			case "transactionDate":
				return oBankTransaction.transactionDate;
			case "transactionFee":
				return oBankTransaction.transactionFee;
			case "transactionDisplayName":
				return oBankTransaction.transactionDisplayName;
			case "transactionCompleteName":
				return oBankTransaction.transactionCompleteName;
			case "transactionId":
				return oBankTransaction.transactionId;
			case "pageUrl":
				return oBankTransaction.pageUrl;
			case "objectSuggest":
				return oBankTransaction.objectSuggest;
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
				o = attributeBankTransaction(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeBankTransaction(String var, Object val) {
		BankTransaction oBankTransaction = (BankTransaction)this;
		switch(var) {
			case "accountKey":
				oBankTransaction.setAccountKey((Long)val);
				return val;
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
					o = defineBankTransaction(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineBankTransaction(String var, String val) {
		switch(var) {
			case "transactionCode":
				setTransactionCode(val);
				savesBankTransaction.add(var);
				return val;
			case "transactionReferenceId":
				setTransactionReferenceId(val);
				savesBankTransaction.add(var);
				return val;
			case "transactionAmount":
				setTransactionAmount(val);
				savesBankTransaction.add(var);
				return val;
			case "transactionDateTime":
				setTransactionDateTime(val);
				savesBankTransaction.add(var);
				return val;
			case "transactionFee":
				setTransactionFee(val);
				savesBankTransaction.add(var);
				return val;
			case "transactionDisplayName":
				setTransactionDisplayName(val);
				savesBankTransaction.add(var);
				return val;
			default:
				return super.defineCluster(var, val);
		}
	}

	/////////////////
	// saves //
	/////////////////

	protected List<String> savesBankTransaction = new ArrayList<String>();

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrDocument solrDocument) {
		populateBankTransaction(solrDocument);
	}
	public void populateBankTransaction(SolrDocument solrDocument) {
		BankTransaction oBankTransaction = (BankTransaction)this;
		savesBankTransaction = (List<String>)solrDocument.get("savesBankTransaction_stored_strings");
		if(savesBankTransaction != null) {

			if(savesBankTransaction.contains("transactionKey")) {
				Long transactionKey = (Long)solrDocument.get("transactionKey_stored_long");
				if(transactionKey != null)
					oBankTransaction.setTransactionKey(transactionKey);
			}

			Long accountKey = (Long)solrDocument.get("accountKey_stored_long");
			if(accountKey != null)
				oBankTransaction.setAccountKey(accountKey);

			if(savesBankTransaction.contains("accountCompleteName")) {
				String accountCompleteName = (String)solrDocument.get("accountCompleteName_stored_string");
				if(accountCompleteName != null)
					oBankTransaction.setAccountCompleteName(accountCompleteName);
			}

			if(savesBankTransaction.contains("accountNumber")) {
				String accountNumber = (String)solrDocument.get("accountNumber_stored_string");
				if(accountNumber != null)
					oBankTransaction.setAccountNumber(accountNumber);
			}

			if(savesBankTransaction.contains("transactionCode")) {
				String transactionCode = (String)solrDocument.get("transactionCode_stored_string");
				if(transactionCode != null)
					oBankTransaction.setTransactionCode(transactionCode);
			}

			if(savesBankTransaction.contains("transactionCodeCompleteName")) {
				String transactionCodeCompleteName = (String)solrDocument.get("transactionCodeCompleteName_stored_string");
				if(transactionCodeCompleteName != null)
					oBankTransaction.setTransactionCodeCompleteName(transactionCodeCompleteName);
			}

			if(savesBankTransaction.contains("transactionReferenceId")) {
				String transactionReferenceId = (String)solrDocument.get("transactionReferenceId_stored_string");
				if(transactionReferenceId != null)
					oBankTransaction.setTransactionReferenceId(transactionReferenceId);
			}

			if(savesBankTransaction.contains("transactionAmount")) {
				Double transactionAmount = (Double)solrDocument.get("transactionAmount_stored_double");
				if(transactionAmount != null)
					oBankTransaction.setTransactionAmount(transactionAmount);
			}

			if(savesBankTransaction.contains("transactionDateTime")) {
				Date transactionDateTime = (Date)solrDocument.get("transactionDateTime_stored_date");
				if(transactionDateTime != null)
					oBankTransaction.setTransactionDateTime(transactionDateTime);
			}

			if(savesBankTransaction.contains("transactionDate")) {
				Date transactionDate = (Date)solrDocument.get("transactionDate_stored_date");
				if(transactionDate != null)
					oBankTransaction.setTransactionDate(transactionDate);
			}

			if(savesBankTransaction.contains("transactionFee")) {
				Boolean transactionFee = (Boolean)solrDocument.get("transactionFee_stored_boolean");
				if(transactionFee != null)
					oBankTransaction.setTransactionFee(transactionFee);
			}

			if(savesBankTransaction.contains("transactionDisplayName")) {
				String transactionDisplayName = (String)solrDocument.get("transactionDisplayName_stored_string");
				if(transactionDisplayName != null)
					oBankTransaction.setTransactionDisplayName(transactionDisplayName);
			}

			if(savesBankTransaction.contains("transactionCompleteName")) {
				String transactionCompleteName = (String)solrDocument.get("transactionCompleteName_stored_string");
				if(transactionCompleteName != null)
					oBankTransaction.setTransactionCompleteName(transactionCompleteName);
			}

			if(savesBankTransaction.contains("transactionId")) {
				String transactionId = (String)solrDocument.get("transactionId_stored_string");
				if(transactionId != null)
					oBankTransaction.setTransactionId(transactionId);
			}

			if(savesBankTransaction.contains("pageUrl")) {
				String pageUrl = (String)solrDocument.get("pageUrl_stored_string");
				if(pageUrl != null)
					oBankTransaction.setPageUrl(pageUrl);
			}

			if(savesBankTransaction.contains("objectSuggest")) {
				String objectSuggest = (String)solrDocument.get("objectSuggest_suggested");
				oBankTransaction.setObjectSuggest(objectSuggest);
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
			solrQuery.addFilterQuery("id:" + ClientUtils.escapeQueryChars("org.computate.bancaire.enus.transaction.BankTransaction"));
			QueryResponse queryResponse = siteRequest.getSiteContext_().getSolrClient().query(solrQuery);
			if(queryResponse.getResults().size() > 0)
				siteRequest.setSolrDocument(queryResponse.getResults().get(0));
			BankTransaction o = new BankTransaction();
			o.siteRequestBankTransaction(siteRequest);
			o.initDeepBankTransaction(siteRequest);
			o.indexBankTransaction();
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}


	@Override public void indexForClass() {
		indexBankTransaction();
	}

	@Override public void indexForClass(SolrInputDocument document) {
		indexBankTransaction(document);
	}

	public void indexBankTransaction(SolrClient clientSolr) {
		try {
			SolrInputDocument document = new SolrInputDocument();
			indexBankTransaction(document);
			clientSolr.add(document);
			clientSolr.commit(false, false, true);
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public void indexBankTransaction() {
		try {
			SolrInputDocument document = new SolrInputDocument();
			indexBankTransaction(document);
			SolrClient clientSolr = siteRequest_.getSiteContext_().getSolrClient();
			clientSolr.add(document);
			clientSolr.commit(false, false, true);
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public void indexBankTransaction(SolrInputDocument document) {
		if(savesBankTransaction != null)
			document.addField("savesBankTransaction_stored_strings", savesBankTransaction);

		if(transactionKey != null) {
			document.addField("transactionKey_indexed_long", transactionKey);
			document.addField("transactionKey_stored_long", transactionKey);
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
		if(transactionCode != null) {
			document.addField("transactionCode_indexed_string", transactionCode);
			document.addField("transactionCode_stored_string", transactionCode);
		}
		if(transactionCodeCompleteName != null) {
			document.addField("transactionCodeCompleteName_indexed_string", transactionCodeCompleteName);
			document.addField("transactionCodeCompleteName_stored_string", transactionCodeCompleteName);
		}
		if(transactionReferenceId != null) {
			document.addField("transactionReferenceId_indexed_string", transactionReferenceId);
			document.addField("transactionReferenceId_stored_string", transactionReferenceId);
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
		if(transactionDisplayName != null) {
			document.addField("transactionDisplayName_indexed_string", transactionDisplayName);
			document.addField("transactionDisplayName_stored_string", transactionDisplayName);
		}
		if(transactionCompleteName != null) {
			document.addField("transactionCompleteName_indexed_string", transactionCompleteName);
			document.addField("transactionCompleteName_stored_string", transactionCompleteName);
		}
		if(transactionId != null) {
			document.addField("transactionId_indexed_string", transactionId);
			document.addField("transactionId_stored_string", transactionId);
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

	public void unindexBankTransaction() {
		try {
		SiteRequestEnUS siteRequest = new SiteRequestEnUS();
			siteRequest.initDeepSiteRequestEnUS();
			SiteContextEnUS siteContext = new SiteContextEnUS();
			siteContext.initDeepSiteContextEnUS();
			siteRequest.setSiteContext_(siteContext);
			siteRequest.setSiteConfig_(siteContext.getSiteConfig());
			initDeepBankTransaction(siteRequest);
			SolrClient solrClient = siteContext.getSolrClient();
			solrClient.deleteById(id.toString());
			solrClient.commit(false, false, true);
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public static String varIndexedBankTransaction(String entityVar) {
		switch(entityVar) {
			case "transactionKey":
				return "transactionKey_indexed_long";
			case "accountKey":
				return "accountKey_indexed_long";
			case "accountCompleteName":
				return "accountCompleteName_indexed_string";
			case "accountNumber":
				return "accountNumber_indexed_string";
			case "transactionCode":
				return "transactionCode_indexed_string";
			case "transactionCodeCompleteName":
				return "transactionCodeCompleteName_indexed_string";
			case "transactionReferenceId":
				return "transactionReferenceId_indexed_string";
			case "transactionAmount":
				return "transactionAmount_indexed_double";
			case "transactionDateTime":
				return "transactionDateTime_indexed_date";
			case "transactionDate":
				return "transactionDate_indexed_date";
			case "transactionFee":
				return "transactionFee_indexed_boolean";
			case "transactionDisplayName":
				return "transactionDisplayName_indexed_string";
			case "transactionCompleteName":
				return "transactionCompleteName_indexed_string";
			case "transactionId":
				return "transactionId_indexed_string";
			case "pageUrl":
				return "pageUrl_indexed_string";
			case "objectSuggest":
				return "objectSuggest_indexed_string";
			default:
				return Cluster.varIndexedCluster(entityVar);
		}
	}

	public static String varSearchBankTransaction(String entityVar) {
		switch(entityVar) {
			case "objectSuggest":
				return "objectSuggest_suggested";
			default:
				return Cluster.varSearchCluster(entityVar);
		}
	}

	public static String varSuggestBankTransaction(String entityVar) {
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
		storeBankTransaction(solrDocument);
	}
	public void storeBankTransaction(SolrDocument solrDocument) {
		BankTransaction oBankTransaction = (BankTransaction)this;

		Long transactionKey = (Long)solrDocument.get("transactionKey_stored_long");
		if(transactionKey != null)
			oBankTransaction.setTransactionKey(transactionKey);

		Long accountKey = (Long)solrDocument.get("accountKey_stored_long");
		if(accountKey != null)
			oBankTransaction.setAccountKey(accountKey);

		String accountCompleteName = (String)solrDocument.get("accountCompleteName_stored_string");
		if(accountCompleteName != null)
			oBankTransaction.setAccountCompleteName(accountCompleteName);

		String accountNumber = (String)solrDocument.get("accountNumber_stored_string");
		if(accountNumber != null)
			oBankTransaction.setAccountNumber(accountNumber);

		String transactionCode = (String)solrDocument.get("transactionCode_stored_string");
		if(transactionCode != null)
			oBankTransaction.setTransactionCode(transactionCode);

		String transactionCodeCompleteName = (String)solrDocument.get("transactionCodeCompleteName_stored_string");
		if(transactionCodeCompleteName != null)
			oBankTransaction.setTransactionCodeCompleteName(transactionCodeCompleteName);

		String transactionReferenceId = (String)solrDocument.get("transactionReferenceId_stored_string");
		if(transactionReferenceId != null)
			oBankTransaction.setTransactionReferenceId(transactionReferenceId);

		Double transactionAmount = (Double)solrDocument.get("transactionAmount_stored_double");
		if(transactionAmount != null)
			oBankTransaction.setTransactionAmount(transactionAmount);

		Date transactionDateTime = (Date)solrDocument.get("transactionDateTime_stored_date");
		if(transactionDateTime != null)
			oBankTransaction.setTransactionDateTime(transactionDateTime);

		Date transactionDate = (Date)solrDocument.get("transactionDate_stored_date");
		if(transactionDate != null)
			oBankTransaction.setTransactionDate(transactionDate);

		Boolean transactionFee = (Boolean)solrDocument.get("transactionFee_stored_boolean");
		if(transactionFee != null)
			oBankTransaction.setTransactionFee(transactionFee);

		String transactionDisplayName = (String)solrDocument.get("transactionDisplayName_stored_string");
		if(transactionDisplayName != null)
			oBankTransaction.setTransactionDisplayName(transactionDisplayName);

		String transactionCompleteName = (String)solrDocument.get("transactionCompleteName_stored_string");
		if(transactionCompleteName != null)
			oBankTransaction.setTransactionCompleteName(transactionCompleteName);

		String transactionId = (String)solrDocument.get("transactionId_stored_string");
		if(transactionId != null)
			oBankTransaction.setTransactionId(transactionId);

		String pageUrl = (String)solrDocument.get("pageUrl_stored_string");
		if(pageUrl != null)
			oBankTransaction.setPageUrl(pageUrl);

		String objectSuggest = (String)solrDocument.get("objectSuggest_suggested");
		oBankTransaction.setObjectSuggest(objectSuggest);

		super.storeCluster(solrDocument);
	}

	//////////////////
	// patchRequest //
	//////////////////

	public void patchRequestBankTransaction() {
		PatchRequest patchRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getPatchRequest_).orElse(null);
		BankTransaction original = (BankTransaction)Optional.ofNullable(patchRequest).map(PatchRequest::getOriginal).orElse(null);
		if(original != null) {
			if(!Objects.equals(accountKey, original.getAccountKey()))
				patchRequest.addVars("accountKey");
			if(!Objects.equals(transactionCode, original.getTransactionCode()))
				patchRequest.addVars("transactionCode");
			if(!Objects.equals(transactionReferenceId, original.getTransactionReferenceId()))
				patchRequest.addVars("transactionReferenceId");
			if(!Objects.equals(transactionAmount, original.getTransactionAmount()))
				patchRequest.addVars("transactionAmount");
			if(!Objects.equals(transactionDateTime, original.getTransactionDateTime()))
				patchRequest.addVars("transactionDateTime");
			if(!Objects.equals(transactionFee, original.getTransactionFee()))
				patchRequest.addVars("transactionFee");
			if(!Objects.equals(transactionDisplayName, original.getTransactionDisplayName()))
				patchRequest.addVars("transactionDisplayName");
			super.patchRequestCluster();
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(super.hashCode(), accountKey, transactionCode, transactionReferenceId, transactionAmount, transactionDateTime, transactionFee, transactionDisplayName);
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof BankTransaction))
			return false;
		BankTransaction that = (BankTransaction)o;
		return super.equals(o)
				&& Objects.equals( accountKey, that.accountKey )
				&& Objects.equals( transactionCode, that.transactionCode )
				&& Objects.equals( transactionReferenceId, that.transactionReferenceId )
				&& Objects.equals( transactionAmount, that.transactionAmount )
				&& Objects.equals( transactionDateTime, that.transactionDateTime )
				&& Objects.equals( transactionFee, that.transactionFee )
				&& Objects.equals( transactionDisplayName, that.transactionDisplayName );
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("BankTransaction { ");
		sb.append( "accountKey: " ).append(accountKey);
		sb.append( ", transactionCode: \"" ).append(transactionCode).append( "\"" );
		sb.append( ", transactionReferenceId: \"" ).append(transactionReferenceId).append( "\"" );
		sb.append( ", transactionAmount: " ).append(transactionAmount);
		sb.append( ", transactionDateTime: " ).append(transactionDateTime);
		sb.append( ", transactionFee: " ).append(transactionFee);
		sb.append( ", transactionDisplayName: \"" ).append(transactionDisplayName).append( "\"" );
		sb.append(" }");
		return sb.toString();
	}
}
