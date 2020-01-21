package org.computate.bancaire.enus.account;

import org.computate.bancaire.enus.request.patch.PatchRequest;
import java.lang.Double;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.computate.bancaire.enus.request.SiteRequestEnUS;
import io.vertx.core.logging.LoggerFactory;
import java.text.NumberFormat;
import org.computate.bancaire.enus.contexte.SiteContextEnUS;
import java.util.ArrayList;
import java.lang.Long;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.vertx.core.json.JsonObject;
import org.computate.bancaire.enus.writer.AllWriter;
import java.lang.String;
import io.vertx.core.logging.Logger;
import org.computate.bancaire.enus.cluster.Cluster;
import java.math.MathContext;
import org.apache.solr.client.solrj.response.QueryResponse;
import java.util.Set;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.solr.client.solrj.SolrClient;
import java.util.Objects;
import io.vertx.core.json.JsonArray;
import org.apache.solr.common.SolrDocument;
import java.util.List;
import org.computate.bancaire.enus.wrap.Wrap;
import org.apache.solr.client.solrj.SolrQuery;
import io.vertx.ext.sql.SQLConnection;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import io.vertx.ext.sql.SQLClient;
import org.apache.solr.client.solrj.util.ClientUtils;
import org.apache.solr.common.SolrInputDocument;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.account.BankAccount&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class BankAccountGen<DEV> extends Cluster {
	private static final Logger LOGGER = LoggerFactory.getLogger(BankAccount.class);

	public static final String BankAccount_UnNom = "an account";
	public static final String BankAccount_Ce = "this ";
	public static final String BankAccount_CeNom = "this account";
	public static final String BankAccount_Un = "a ";
	public static final String BankAccount_LeNom = "theaccount";
	public static final String BankAccount_NomSingulier = "account";
	public static final String BankAccount_NomPluriel = "accounts";
	public static final String BankAccount_NomActuel = "current account";
	public static final String BankAccount_TousNom = "all the accounts";
	public static final String BankAccount_RechercherTousNomPar = "search accounts by ";
	public static final String BankAccount_LesNoms = "the accounts";
	public static final String BankAccount_AucunNomTrouve = "no account found";
	public static final String BankAccount_NomVar = "account";
	public static final String BankAccount_DeNom = "of account";
	public static final String BankAccount_AdjectifPluriel = "bank";
	public static final String BankAccount_AdjectifVar = "bank";
	public static final String BankAccount_UnNomAdjectif = "a bank account";
	public static final String BankAccount_NomAdjectifSingulier = "bank account";
	public static final String BankAccount_NomAdjectifPluriel = "bank accounts";
	public static final String BankAccount_Couleur = "gray";
	public static final String BankAccount_IconeGroupe = "duotone";
	public static final String BankAccount_IconeNom = "money-check";

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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.account.BankAccount&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:accountKey">Trouver l'entité accountKey dans Solr</a>
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
	public BankAccount setAccountKey(String o) {
		if(NumberUtils.isParsable(o))
			this.accountKey = Long.parseLong(o);
		this.accountKeyWrap.alreadyInitialized = true;
		return (BankAccount)this;
	}
	protected BankAccount accountKeyInit() {
		if(!accountKeyWrap.alreadyInitialized) {
			_accountKey(accountKeyWrap);
			if(accountKey == null)
				setAccountKey(accountKeyWrap.o);
		}
		accountKeyWrap.alreadyInitialized(true);
		return (BankAccount)this;
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
		return "key";
	}

	public String htmTooltipAccountKey() {
		return null;
	}

	public String htmAccountKey() {
		return accountKey == null ? "" : StringEscapeUtils.escapeHtml4(strAccountKey());
	}

	//////////////
	// yearKeys //
	//////////////

	/**	L'entité « yearKeys »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut List<Long>(). 
	 */
	protected List<Long> yearKeys = new java.util.ArrayList<java.lang.Long>();
	@JsonIgnore
	public Wrap<List<Long>> yearKeysWrap = new Wrap<List<Long>>().p(this).c(List.class).var("yearKeys").o(yearKeys);

	/**	<br/>L'entité « yearKeys »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut List<Long>(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.account.BankAccount&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:yearKeys">Trouver l'entité yearKeys dans Solr</a>
	 * <br/>
	 * @param yearKeys est l'entité déjà construit. 
	 **/
	protected abstract void _yearKeys(List<Long> o);

	public List<Long> getYearKeys() {
		return yearKeys;
	}

	public void setYearKeys(List<Long> yearKeys) {
		this.yearKeys = yearKeys;
		this.yearKeysWrap.alreadyInitialized = true;
	}
	public BankAccount addYearKeys(Long...objets) {
		for(Long o : objets) {
			addYearKeys(o);
		}
		return (BankAccount)this;
	}
	public BankAccount addYearKeys(Long o) {
		if(o != null && !yearKeys.contains(o))
			this.yearKeys.add(o);
		return (BankAccount)this;
	}
	public BankAccount setYearKeys(JsonArray objets) {
		yearKeys.clear();
		for(int i = 0; i < objets.size(); i++) {
			Long o = objets.getLong(i);
			addYearKeys(o);
		}
		return (BankAccount)this;
	}
	public BankAccount addYearKeys(String o) {
		if(NumberUtils.isParsable(o)) {
			Long p = Long.parseLong(o);
			addYearKeys(p);
		}
		return (BankAccount)this;
	}
	protected BankAccount yearKeysInit() {
		if(!yearKeysWrap.alreadyInitialized) {
			_yearKeys(yearKeys);
		}
		yearKeysWrap.alreadyInitialized(true);
		return (BankAccount)this;
	}

	public List<Long> solrYearKeys() {
		return yearKeys;
	}

	public String strYearKeys() {
		return yearKeys == null ? "" : yearKeys.toString();
	}

	public String jsonYearKeys() {
		return yearKeys == null ? "" : yearKeys.toString();
	}

	public String nomAffichageYearKeys() {
		return "transactions";
	}

	public String htmTooltipYearKeys() {
		return null;
	}

	public String htmYearKeys() {
		return yearKeys == null ? "" : StringEscapeUtils.escapeHtml4(strYearKeys());
	}

	public void inputYearKeys(String classApiMethodMethod) {
		BankAccount s = (BankAccount)this;
	}

	public void htmYearKeys(String classApiMethodMethod) {
		BankAccount s = (BankAccount)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-gray ").f();
							e("label").a("class", "").f().sx("transactions").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").f().sx(strYearKeys()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.account.BankAccount&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:accountNumber">Trouver l'entité accountNumber dans Solr</a>
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
	protected BankAccount accountNumberInit() {
		if(!accountNumberWrap.alreadyInitialized) {
			_accountNumber(accountNumberWrap);
			if(accountNumber == null)
				setAccountNumber(accountNumberWrap.o);
		}
		accountNumberWrap.alreadyInitialized(true);
		return (BankAccount)this;
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
		return "account number";
	}

	public String htmTooltipAccountNumber() {
		return null;
	}

	public String htmAccountNumber() {
		return accountNumber == null ? "" : StringEscapeUtils.escapeHtml4(strAccountNumber());
	}

	public void inputAccountNumber(String classApiMethodMethod) {
		BankAccount s = (BankAccount)this;
		e("input")
			.a("type", "text")
			.a("placeholder", "account number")
			.a("id", classApiMethodMethod, "_accountNumber");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setAccountNumber inputBankAccount", pk, "AccountNumber w3-input w3-border ");
				a("name", "setAccountNumber");
			} else {
				a("class", "valueAccountNumber w3-input w3-border inputBankAccount", pk, "AccountNumber w3-input w3-border ");
				a("name", "accountNumber");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchBankAccountVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setAccountNumber', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_accountNumber')); }, function() { addError($('#", classApiMethodMethod, "_accountNumber')); }); ");
			}
			a("value", strAccountNumber())
		.fg();

	}

	public void htmAccountNumber(String classApiMethodMethod) {
		BankAccount s = (BankAccount)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestBankAccountAccountNumber").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-gray ").f();
							e("label").a("for", classApiMethodMethod, "_accountNumber").a("class", "").f().sx("account number").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputAccountNumber(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-gray ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_accountNumber')); $('#", classApiMethodMethod, "_accountNumber').val(null); patchBankAccountVal([{ name: 'fq', value: 'pk:' + $('#BankAccountForm :input[name=pk]').val() }], 'setAccountNumber', null, function() { addGlow($('#", classApiMethodMethod, "_accountNumber')); }, function() { addError($('#", classApiMethodMethod, "_accountNumber')); }); ")
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

	////////////////////////
	// accountPhoneNumber //
	////////////////////////

	/**	L'entité « accountPhoneNumber »
	 *	 is defined as null before being initialized. 
	 */
	protected String accountPhoneNumber;
	@JsonIgnore
	public Wrap<String> accountPhoneNumberWrap = new Wrap<String>().p(this).c(String.class).var("accountPhoneNumber").o(accountPhoneNumber);

	/**	<br/>L'entité « accountPhoneNumber »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.account.BankAccount&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:accountPhoneNumber">Trouver l'entité accountPhoneNumber dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _accountPhoneNumber(Wrap<String> c);

	public String getAccountPhoneNumber() {
		return accountPhoneNumber;
	}

	public void setAccountPhoneNumber(String accountPhoneNumber) {
		this.accountPhoneNumber = accountPhoneNumber;
		this.accountPhoneNumberWrap.alreadyInitialized = true;
	}
	protected BankAccount accountPhoneNumberInit() {
		if(!accountPhoneNumberWrap.alreadyInitialized) {
			_accountPhoneNumber(accountPhoneNumberWrap);
			if(accountPhoneNumber == null)
				setAccountPhoneNumber(accountPhoneNumberWrap.o);
		}
		accountPhoneNumberWrap.alreadyInitialized(true);
		return (BankAccount)this;
	}

	public String solrAccountPhoneNumber() {
		return accountPhoneNumber;
	}

	public String strAccountPhoneNumber() {
		return accountPhoneNumber == null ? "" : accountPhoneNumber;
	}

	public String jsonAccountPhoneNumber() {
		return accountPhoneNumber == null ? "" : accountPhoneNumber;
	}

	public String nomAffichageAccountPhoneNumber() {
		return "phone number";
	}

	public String htmTooltipAccountPhoneNumber() {
		return null;
	}

	public String htmAccountPhoneNumber() {
		return accountPhoneNumber == null ? "" : StringEscapeUtils.escapeHtml4(strAccountPhoneNumber());
	}

	public void inputAccountPhoneNumber(String classApiMethodMethod) {
		BankAccount s = (BankAccount)this;
		e("input")
			.a("type", "text")
			.a("placeholder", "phone number")
			.a("id", classApiMethodMethod, "_accountPhoneNumber");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setAccountPhoneNumber inputBankAccount", pk, "AccountPhoneNumber w3-input w3-border ");
				a("name", "setAccountPhoneNumber");
			} else {
				a("class", "valueAccountPhoneNumber w3-input w3-border inputBankAccount", pk, "AccountPhoneNumber w3-input w3-border ");
				a("name", "accountPhoneNumber");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchBankAccountVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setAccountPhoneNumber', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_accountPhoneNumber')); }, function() { addError($('#", classApiMethodMethod, "_accountPhoneNumber')); }); ");
			}
			a("value", strAccountPhoneNumber())
		.fg();

	}

	public void htmAccountPhoneNumber(String classApiMethodMethod) {
		BankAccount s = (BankAccount)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestBankAccountAccountPhoneNumber").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-gray ").f();
							e("label").a("for", classApiMethodMethod, "_accountPhoneNumber").a("class", "").f().sx("phone number").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputAccountPhoneNumber(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-gray ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_accountPhoneNumber')); $('#", classApiMethodMethod, "_accountPhoneNumber').val(null); patchBankAccountVal([{ name: 'fq', value: 'pk:' + $('#BankAccountForm :input[name=pk]').val() }], 'setAccountPhoneNumber', null, function() { addGlow($('#", classApiMethodMethod, "_accountPhoneNumber')); }, function() { addError($('#", classApiMethodMethod, "_accountPhoneNumber')); }); ")
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

	//////////////////////////////
	// accountAdministratorName //
	//////////////////////////////

	/**	L'entité « accountAdministratorName »
	 *	 is defined as null before being initialized. 
	 */
	protected String accountAdministratorName;
	@JsonIgnore
	public Wrap<String> accountAdministratorNameWrap = new Wrap<String>().p(this).c(String.class).var("accountAdministratorName").o(accountAdministratorName);

	/**	<br/>L'entité « accountAdministratorName »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.account.BankAccount&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:accountAdministratorName">Trouver l'entité accountAdministratorName dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _accountAdministratorName(Wrap<String> c);

	public String getAccountAdministratorName() {
		return accountAdministratorName;
	}

	public void setAccountAdministratorName(String accountAdministratorName) {
		this.accountAdministratorName = accountAdministratorName;
		this.accountAdministratorNameWrap.alreadyInitialized = true;
	}
	protected BankAccount accountAdministratorNameInit() {
		if(!accountAdministratorNameWrap.alreadyInitialized) {
			_accountAdministratorName(accountAdministratorNameWrap);
			if(accountAdministratorName == null)
				setAccountAdministratorName(accountAdministratorNameWrap.o);
		}
		accountAdministratorNameWrap.alreadyInitialized(true);
		return (BankAccount)this;
	}

	public String solrAccountAdministratorName() {
		return accountAdministratorName;
	}

	public String strAccountAdministratorName() {
		return accountAdministratorName == null ? "" : accountAdministratorName;
	}

	public String jsonAccountAdministratorName() {
		return accountAdministratorName == null ? "" : accountAdministratorName;
	}

	public String nomAffichageAccountAdministratorName() {
		return "administrator of the account";
	}

	public String htmTooltipAccountAdministratorName() {
		return null;
	}

	public String htmAccountAdministratorName() {
		return accountAdministratorName == null ? "" : StringEscapeUtils.escapeHtml4(strAccountAdministratorName());
	}

	public void inputAccountAdministratorName(String classApiMethodMethod) {
		BankAccount s = (BankAccount)this;
		e("input")
			.a("type", "text")
			.a("placeholder", "administrator of the account")
			.a("id", classApiMethodMethod, "_accountAdministratorName");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setAccountAdministratorName inputBankAccount", pk, "AccountAdministratorName w3-input w3-border ");
				a("name", "setAccountAdministratorName");
			} else {
				a("class", "valueAccountAdministratorName w3-input w3-border inputBankAccount", pk, "AccountAdministratorName w3-input w3-border ");
				a("name", "accountAdministratorName");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchBankAccountVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setAccountAdministratorName', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_accountAdministratorName')); }, function() { addError($('#", classApiMethodMethod, "_accountAdministratorName')); }); ");
			}
			a("value", strAccountAdministratorName())
		.fg();

	}

	public void htmAccountAdministratorName(String classApiMethodMethod) {
		BankAccount s = (BankAccount)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestBankAccountAccountAdministratorName").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-gray ").f();
							e("label").a("for", classApiMethodMethod, "_accountAdministratorName").a("class", "").f().sx("administrator of the account").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputAccountAdministratorName(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-gray ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_accountAdministratorName')); $('#", classApiMethodMethod, "_accountAdministratorName').val(null); patchBankAccountVal([{ name: 'fq', value: 'pk:' + $('#BankAccountForm :input[name=pk]').val() }], 'setAccountAdministratorName', null, function() { addGlow($('#", classApiMethodMethod, "_accountAdministratorName')); }, function() { addError($('#", classApiMethodMethod, "_accountAdministratorName')); }); ")
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
	// accountLocation //
	/////////////////////

	/**	L'entité « accountLocation »
	 *	 is defined as null before being initialized. 
	 */
	protected String accountLocation;
	@JsonIgnore
	public Wrap<String> accountLocationWrap = new Wrap<String>().p(this).c(String.class).var("accountLocation").o(accountLocation);

	/**	<br/>L'entité « accountLocation »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.account.BankAccount&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:accountLocation">Trouver l'entité accountLocation dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _accountLocation(Wrap<String> c);

	public String getAccountLocation() {
		return accountLocation;
	}

	public void setAccountLocation(String accountLocation) {
		this.accountLocation = accountLocation;
		this.accountLocationWrap.alreadyInitialized = true;
	}
	protected BankAccount accountLocationInit() {
		if(!accountLocationWrap.alreadyInitialized) {
			_accountLocation(accountLocationWrap);
			if(accountLocation == null)
				setAccountLocation(accountLocationWrap.o);
		}
		accountLocationWrap.alreadyInitialized(true);
		return (BankAccount)this;
	}

	public String solrAccountLocation() {
		return accountLocation;
	}

	public String strAccountLocation() {
		return accountLocation == null ? "" : accountLocation;
	}

	public String jsonAccountLocation() {
		return accountLocation == null ? "" : accountLocation;
	}

	public String nomAffichageAccountLocation() {
		return "location";
	}

	public String htmTooltipAccountLocation() {
		return null;
	}

	public String htmAccountLocation() {
		return accountLocation == null ? "" : StringEscapeUtils.escapeHtml4(strAccountLocation());
	}

	public void inputAccountLocation(String classApiMethodMethod) {
		BankAccount s = (BankAccount)this;
		e("input")
			.a("type", "text")
			.a("placeholder", "location")
			.a("id", classApiMethodMethod, "_accountLocation");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setAccountLocation inputBankAccount", pk, "AccountLocation w3-input w3-border ");
				a("name", "setAccountLocation");
			} else {
				a("class", "valueAccountLocation w3-input w3-border inputBankAccount", pk, "AccountLocation w3-input w3-border ");
				a("name", "accountLocation");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchBankAccountVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setAccountLocation', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_accountLocation')); }, function() { addError($('#", classApiMethodMethod, "_accountLocation')); }); ");
			}
			a("value", strAccountLocation())
		.fg();

	}

	public void htmAccountLocation(String classApiMethodMethod) {
		BankAccount s = (BankAccount)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestBankAccountAccountLocation").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-gray ").f();
							e("label").a("for", classApiMethodMethod, "_accountLocation").a("class", "").f().sx("location").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputAccountLocation(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-gray ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_accountLocation')); $('#", classApiMethodMethod, "_accountLocation').val(null); patchBankAccountVal([{ name: 'fq', value: 'pk:' + $('#BankAccountForm :input[name=pk]').val() }], 'setAccountLocation', null, function() { addGlow($('#", classApiMethodMethod, "_accountLocation')); }, function() { addError($('#", classApiMethodMethod, "_accountLocation')); }); ")
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

	////////////////////
	// accountAddress //
	////////////////////

	/**	L'entité « accountAddress »
	 *	 is defined as null before being initialized. 
	 */
	protected String accountAddress;
	@JsonIgnore
	public Wrap<String> accountAddressWrap = new Wrap<String>().p(this).c(String.class).var("accountAddress").o(accountAddress);

	/**	<br/>L'entité « accountAddress »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.account.BankAccount&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:accountAddress">Trouver l'entité accountAddress dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _accountAddress(Wrap<String> c);

	public String getAccountAddress() {
		return accountAddress;
	}

	public void setAccountAddress(String accountAddress) {
		this.accountAddress = accountAddress;
		this.accountAddressWrap.alreadyInitialized = true;
	}
	protected BankAccount accountAddressInit() {
		if(!accountAddressWrap.alreadyInitialized) {
			_accountAddress(accountAddressWrap);
			if(accountAddress == null)
				setAccountAddress(accountAddressWrap.o);
		}
		accountAddressWrap.alreadyInitialized(true);
		return (BankAccount)this;
	}

	public String solrAccountAddress() {
		return accountAddress;
	}

	public String strAccountAddress() {
		return accountAddress == null ? "" : accountAddress;
	}

	public String jsonAccountAddress() {
		return accountAddress == null ? "" : accountAddress;
	}

	public String nomAffichageAccountAddress() {
		return "address";
	}

	public String htmTooltipAccountAddress() {
		return null;
	}

	public String htmAccountAddress() {
		return accountAddress == null ? "" : StringEscapeUtils.escapeHtml4(strAccountAddress());
	}

	public void inputAccountAddress(String classApiMethodMethod) {
		BankAccount s = (BankAccount)this;
		e("textarea")
			.a("placeholder", "address")
			.a("id", classApiMethodMethod, "_accountAddress");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setAccountAddress inputBankAccount", pk, "AccountAddress w3-input w3-border ");
				a("name", "setAccountAddress");
			} else {
				a("class", "valueAccountAddress w3-input w3-border inputBankAccount", pk, "AccountAddress w3-input w3-border ");
				a("name", "accountAddress");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchBankAccountVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setAccountAddress', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_accountAddress')); }, function() { addError($('#", classApiMethodMethod, "_accountAddress')); }); ");
			}
		f().sx(strAccountAddress()).g("textarea");

	}

	public void htmAccountAddress(String classApiMethodMethod) {
		BankAccount s = (BankAccount)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestBankAccountAccountAddress").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-gray ").f();
							e("label").a("for", classApiMethodMethod, "_accountAddress").a("class", "").f().sx("address").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputAccountAddress(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-gray ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_accountAddress')); $('#", classApiMethodMethod, "_accountAddress').val(null); patchBankAccountVal([{ name: 'fq', value: 'pk:' + $('#BankAccountForm :input[name=pk]').val() }], 'setAccountAddress', null, function() { addGlow($('#", classApiMethodMethod, "_accountAddress')); }, function() { addError($('#", classApiMethodMethod, "_accountAddress')); }); ")
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
	// objectSuggestWeight //
	/////////////////////////

	/**	L'entité « objectSuggestWeight »
	 *	 is defined as null before being initialized. 
	 */
	protected Double objectSuggestWeight;
	@JsonIgnore
	public Wrap<Double> objectSuggestWeightWrap = new Wrap<Double>().p(this).c(Double.class).var("objectSuggestWeight").o(objectSuggestWeight);

	/**	<br/>L'entité « objectSuggestWeight »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.account.BankAccount&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:objectSuggestWeight">Trouver l'entité objectSuggestWeight dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _objectSuggestWeight(Wrap<Double> c);

	public Double getObjectSuggestWeight() {
		return objectSuggestWeight;
	}

	public void setObjectSuggestWeight(Double objectSuggestWeight) {
		this.objectSuggestWeight = objectSuggestWeight;
		this.objectSuggestWeightWrap.alreadyInitialized = true;
	}
	public BankAccount setObjectSuggestWeight(String o) {
		if(NumberUtils.isParsable(o))
			this.objectSuggestWeight = Double.parseDouble(o);
		this.objectSuggestWeightWrap.alreadyInitialized = true;
		return (BankAccount)this;
	}
	protected BankAccount objectSuggestWeightInit() {
		if(!objectSuggestWeightWrap.alreadyInitialized) {
			_objectSuggestWeight(objectSuggestWeightWrap);
			if(objectSuggestWeight == null)
				setObjectSuggestWeight(objectSuggestWeightWrap.o);
		}
		objectSuggestWeightWrap.alreadyInitialized(true);
		return (BankAccount)this;
	}

	public Double solrObjectSuggestWeight() {
		return objectSuggestWeight;
	}

	public String strObjectSuggestWeight() {
		return objectSuggestWeight == null ? "" : objectSuggestWeight.toString();
	}

	public String jsonObjectSuggestWeight() {
		return objectSuggestWeight == null ? "" : objectSuggestWeight.toString();
	}

	public String nomAffichageObjectSuggestWeight() {
		return "";
	}

	public String htmTooltipObjectSuggestWeight() {
		return null;
	}

	public String htmObjectSuggestWeight() {
		return objectSuggestWeight == null ? "" : StringEscapeUtils.escapeHtml4(strObjectSuggestWeight());
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.account.BankAccount&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:objectSuggest">Trouver l'entité objectSuggest dans Solr</a>
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
	protected BankAccount objectSuggestInit() {
		if(!objectSuggestWrap.alreadyInitialized) {
			_objectSuggest(objectSuggestWrap);
			if(objectSuggest == null)
				setObjectSuggest(objectSuggestWrap.o);
		}
		objectSuggestWrap.alreadyInitialized(true);
		return (BankAccount)this;
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
		return "r: compteNumero";
	}

	public String htmTooltipObjectSuggest() {
		return null;
	}

	public String htmObjectSuggest() {
		return objectSuggest == null ? "" : StringEscapeUtils.escapeHtml4(strObjectSuggest());
	}

	//////////////////////
	// accountShortName //
	//////////////////////

	/**	L'entité « accountShortName »
	 *	 is defined as null before being initialized. 
	 */
	protected String accountShortName;
	@JsonIgnore
	public Wrap<String> accountShortNameWrap = new Wrap<String>().p(this).c(String.class).var("accountShortName").o(accountShortName);

	/**	<br/>L'entité « accountShortName »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.account.BankAccount&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:accountShortName">Trouver l'entité accountShortName dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _accountShortName(Wrap<String> c);

	public String getAccountShortName() {
		return accountShortName;
	}

	public void setAccountShortName(String accountShortName) {
		this.accountShortName = accountShortName;
		this.accountShortNameWrap.alreadyInitialized = true;
	}
	protected BankAccount accountShortNameInit() {
		if(!accountShortNameWrap.alreadyInitialized) {
			_accountShortName(accountShortNameWrap);
			if(accountShortName == null)
				setAccountShortName(accountShortNameWrap.o);
		}
		accountShortNameWrap.alreadyInitialized(true);
		return (BankAccount)this;
	}

	public String solrAccountShortName() {
		return accountShortName;
	}

	public String strAccountShortName() {
		return accountShortName == null ? "" : accountShortName;
	}

	public String jsonAccountShortName() {
		return accountShortName == null ? "" : accountShortName;
	}

	public String nomAffichageAccountShortName() {
		return "r: compteNumero";
	}

	public String htmTooltipAccountShortName() {
		return null;
	}

	public String htmAccountShortName() {
		return accountShortName == null ? "" : StringEscapeUtils.escapeHtml4(strAccountShortName());
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.account.BankAccount&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:accountCompleteName">Trouver l'entité accountCompleteName dans Solr</a>
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
	protected BankAccount accountCompleteNameInit() {
		if(!accountCompleteNameWrap.alreadyInitialized) {
			_accountCompleteName(accountCompleteNameWrap);
			if(accountCompleteName == null)
				setAccountCompleteName(accountCompleteNameWrap.o);
		}
		accountCompleteNameWrap.alreadyInitialized(true);
		return (BankAccount)this;
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
		return "name";
	}

	public String htmTooltipAccountCompleteName() {
		return null;
	}

	public String htmAccountCompleteName() {
		return accountCompleteName == null ? "" : StringEscapeUtils.escapeHtml4(strAccountCompleteName());
	}

	public void inputAccountCompleteName(String classApiMethodMethod) {
		BankAccount s = (BankAccount)this;
	}

	public void htmAccountCompleteName(String classApiMethodMethod) {
		BankAccount s = (BankAccount)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-gray ").f();
							e("label").a("class", "").f().sx("name").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").f().sx(strAccountCompleteName()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	///////////////
	// accountId //
	///////////////

	/**	L'entité « accountId »
	 *	 is defined as null before being initialized. 
	 */
	protected String accountId;
	@JsonIgnore
	public Wrap<String> accountIdWrap = new Wrap<String>().p(this).c(String.class).var("accountId").o(accountId);

	/**	<br/>L'entité « accountId »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.account.BankAccount&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:accountId">Trouver l'entité accountId dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _accountId(Wrap<String> c);

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
		this.accountIdWrap.alreadyInitialized = true;
	}
	protected BankAccount accountIdInit() {
		if(!accountIdWrap.alreadyInitialized) {
			_accountId(accountIdWrap);
			if(accountId == null)
				setAccountId(accountIdWrap.o);
		}
		accountIdWrap.alreadyInitialized(true);
		return (BankAccount)this;
	}

	public String solrAccountId() {
		return accountId;
	}

	public String strAccountId() {
		return accountId == null ? "" : accountId;
	}

	public String jsonAccountId() {
		return accountId == null ? "" : accountId;
	}

	public String nomAffichageAccountId() {
		return "ID";
	}

	public String htmTooltipAccountId() {
		return null;
	}

	public String htmAccountId() {
		return accountId == null ? "" : StringEscapeUtils.escapeHtml4(strAccountId());
	}

	public void inputAccountId(String classApiMethodMethod) {
		BankAccount s = (BankAccount)this;
	}

	public void htmAccountId(String classApiMethodMethod) {
		BankAccount s = (BankAccount)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-gray ").f();
							e("label").a("class", "").f().sx("ID").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").f().sx(strAccountId()).g("span");
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.account.BankAccount&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageUrl">Trouver l'entité pageUrl dans Solr</a>
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
	protected BankAccount pageUrlInit() {
		if(!pageUrlWrap.alreadyInitialized) {
			_pageUrl(pageUrlWrap);
			if(pageUrl == null)
				setPageUrl(pageUrlWrap.o);
		}
		pageUrlWrap.alreadyInitialized(true);
		return (BankAccount)this;
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

	////////////
	// pageH1 //
	////////////

	/**	L'entité « pageH1 »
	 *	 is defined as null before being initialized. 
	 */
	protected String pageH1;
	@JsonIgnore
	public Wrap<String> pageH1Wrap = new Wrap<String>().p(this).c(String.class).var("pageH1").o(pageH1);

	/**	<br/>L'entité « pageH1 »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.account.BankAccount&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageH1">Trouver l'entité pageH1 dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _pageH1(Wrap<String> c);

	public String getPageH1() {
		return pageH1;
	}

	public void setPageH1(String pageH1) {
		this.pageH1 = pageH1;
		this.pageH1Wrap.alreadyInitialized = true;
	}
	protected BankAccount pageH1Init() {
		if(!pageH1Wrap.alreadyInitialized) {
			_pageH1(pageH1Wrap);
			if(pageH1 == null)
				setPageH1(pageH1Wrap.o);
		}
		pageH1Wrap.alreadyInitialized(true);
		return (BankAccount)this;
	}

	public String solrPageH1() {
		return pageH1;
	}

	public String strPageH1() {
		return pageH1 == null ? "" : pageH1;
	}

	public String jsonPageH1() {
		return pageH1 == null ? "" : pageH1;
	}

	public String nomAffichagePageH1() {
		return null;
	}

	public String htmTooltipPageH1() {
		return null;
	}

	public String htmPageH1() {
		return pageH1 == null ? "" : StringEscapeUtils.escapeHtml4(strPageH1());
	}

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedBankAccount = false;

	public BankAccount initDeepBankAccount(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedBankAccount) {
			alreadyInitializedBankAccount = true;
			initDeepBankAccount();
		}
		return (BankAccount)this;
	}

	public void initDeepBankAccount() {
		initBankAccount();
		super.initDeepCluster(siteRequest_);
	}

	public void initBankAccount() {
		accountKeyInit();
		yearKeysInit();
		accountNumberInit();
		accountPhoneNumberInit();
		accountAdministratorNameInit();
		accountLocationInit();
		accountAddressInit();
		objectSuggestWeightInit();
		objectSuggestInit();
		accountShortNameInit();
		accountCompleteNameInit();
		accountIdInit();
		pageUrlInit();
		pageH1Init();
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepBankAccount(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestBankAccount(SiteRequestEnUS siteRequest_) {
			super.siteRequestCluster(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestBankAccount(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainBankAccount(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainBankAccount(String var) {
		BankAccount oBankAccount = (BankAccount)this;
		switch(var) {
			case "accountKey":
				return oBankAccount.accountKey;
			case "yearKeys":
				return oBankAccount.yearKeys;
			case "accountNumber":
				return oBankAccount.accountNumber;
			case "accountPhoneNumber":
				return oBankAccount.accountPhoneNumber;
			case "accountAdministratorName":
				return oBankAccount.accountAdministratorName;
			case "accountLocation":
				return oBankAccount.accountLocation;
			case "accountAddress":
				return oBankAccount.accountAddress;
			case "objectSuggestWeight":
				return oBankAccount.objectSuggestWeight;
			case "objectSuggest":
				return oBankAccount.objectSuggest;
			case "accountShortName":
				return oBankAccount.accountShortName;
			case "accountCompleteName":
				return oBankAccount.accountCompleteName;
			case "accountId":
				return oBankAccount.accountId;
			case "pageUrl":
				return oBankAccount.pageUrl;
			case "pageH1":
				return oBankAccount.pageH1;
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
				o = attributeBankAccount(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeBankAccount(String var, Object val) {
		BankAccount oBankAccount = (BankAccount)this;
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
					o = defineBankAccount(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineBankAccount(String var, String val) {
		switch(var) {
			case "accountNumber":
				setAccountNumber(val);
				savesBankAccount.add(var);
				return val;
			case "accountPhoneNumber":
				setAccountPhoneNumber(val);
				savesBankAccount.add(var);
				return val;
			case "accountAdministratorName":
				setAccountAdministratorName(val);
				savesBankAccount.add(var);
				return val;
			case "accountLocation":
				setAccountLocation(val);
				savesBankAccount.add(var);
				return val;
			case "accountAddress":
				setAccountAddress(val);
				savesBankAccount.add(var);
				return val;
			default:
				return super.defineCluster(var, val);
		}
	}

	/////////////////
	// saves //
	/////////////////

	protected List<String> savesBankAccount = new ArrayList<String>();

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrDocument solrDocument) {
		populateBankAccount(solrDocument);
	}
	public void populateBankAccount(SolrDocument solrDocument) {
		BankAccount oBankAccount = (BankAccount)this;
		savesBankAccount = (List<String>)solrDocument.get("savesBankAccount_stored_strings");
		if(savesBankAccount != null) {

			if(savesBankAccount.contains("accountKey")) {
				Long accountKey = (Long)solrDocument.get("accountKey_stored_long");
				if(accountKey != null)
					oBankAccount.setAccountKey(accountKey);
			}

			if(savesBankAccount.contains("yearKeys")) {
				List<Long> yearKeys = (List<Long>)solrDocument.get("yearKeys_stored_longs");
				if(yearKeys != null)
					oBankAccount.yearKeys.addAll(yearKeys);
			}

			if(savesBankAccount.contains("accountNumber")) {
				String accountNumber = (String)solrDocument.get("accountNumber_stored_string");
				if(accountNumber != null)
					oBankAccount.setAccountNumber(accountNumber);
			}

			if(savesBankAccount.contains("accountPhoneNumber")) {
				String accountPhoneNumber = (String)solrDocument.get("accountPhoneNumber_stored_string");
				if(accountPhoneNumber != null)
					oBankAccount.setAccountPhoneNumber(accountPhoneNumber);
			}

			if(savesBankAccount.contains("accountAdministratorName")) {
				String accountAdministratorName = (String)solrDocument.get("accountAdministratorName_stored_string");
				if(accountAdministratorName != null)
					oBankAccount.setAccountAdministratorName(accountAdministratorName);
			}

			if(savesBankAccount.contains("accountLocation")) {
				String accountLocation = (String)solrDocument.get("accountLocation_stored_string");
				if(accountLocation != null)
					oBankAccount.setAccountLocation(accountLocation);
			}

			if(savesBankAccount.contains("accountAddress")) {
				String accountAddress = (String)solrDocument.get("accountAddress_stored_string");
				if(accountAddress != null)
					oBankAccount.setAccountAddress(accountAddress);
			}

			if(savesBankAccount.contains("objectSuggest")) {
				String objectSuggest = (String)solrDocument.get("objectSuggest_suggested");
				oBankAccount.setObjectSuggest(objectSuggest);
			}

			if(savesBankAccount.contains("accountShortName")) {
				String accountShortName = (String)solrDocument.get("accountShortName_stored_string");
				if(accountShortName != null)
					oBankAccount.setAccountShortName(accountShortName);
			}

			if(savesBankAccount.contains("accountCompleteName")) {
				String accountCompleteName = (String)solrDocument.get("accountCompleteName_stored_string");
				if(accountCompleteName != null)
					oBankAccount.setAccountCompleteName(accountCompleteName);
			}

			if(savesBankAccount.contains("accountId")) {
				String accountId = (String)solrDocument.get("accountId_stored_string");
				if(accountId != null)
					oBankAccount.setAccountId(accountId);
			}

			if(savesBankAccount.contains("pageUrl")) {
				String pageUrl = (String)solrDocument.get("pageUrl_stored_string");
				if(pageUrl != null)
					oBankAccount.setPageUrl(pageUrl);
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
			solrQuery.addFilterQuery("id:" + ClientUtils.escapeQueryChars("org.computate.bancaire.enus.account.BankAccount"));
			QueryResponse queryResponse = siteRequest.getSiteContext_().getSolrClient().query(solrQuery);
			if(queryResponse.getResults().size() > 0)
				siteRequest.setSolrDocument(queryResponse.getResults().get(0));
			BankAccount o = new BankAccount();
			o.siteRequestBankAccount(siteRequest);
			o.initDeepBankAccount(siteRequest);
			o.indexBankAccount();
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}


	@Override public void indexForClass() {
		indexBankAccount();
	}

	@Override public void indexForClass(SolrInputDocument document) {
		indexBankAccount(document);
	}

	public void indexBankAccount(SolrClient clientSolr) {
		try {
			SolrInputDocument document = new SolrInputDocument();
			indexBankAccount(document);
			clientSolr.add(document);
			clientSolr.commit(false, false, true);
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public void indexBankAccount() {
		try {
			SolrInputDocument document = new SolrInputDocument();
			indexBankAccount(document);
			SolrClient clientSolr = siteRequest_.getSiteContext_().getSolrClient();
			clientSolr.add(document);
			clientSolr.commit(false, false, true);
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public void indexBankAccount(SolrInputDocument document) {
		if(savesBankAccount != null)
			document.addField("savesBankAccount_stored_strings", savesBankAccount);

		if(accountKey != null) {
			document.addField("accountKey_indexed_long", accountKey);
			document.addField("accountKey_stored_long", accountKey);
		}
		if(yearKeys != null) {
			for(java.lang.Long o : yearKeys) {
				document.addField("yearKeys_indexed_longs", o);
			}
			for(java.lang.Long o : yearKeys) {
				document.addField("yearKeys_stored_longs", o);
			}
		}
		if(accountNumber != null) {
			document.addField("accountNumber_indexed_string", accountNumber);
			document.addField("accountNumber_stored_string", accountNumber);
		}
		if(accountPhoneNumber != null) {
			document.addField("accountPhoneNumber_indexed_string", accountPhoneNumber);
			document.addField("accountPhoneNumber_stored_string", accountPhoneNumber);
		}
		if(accountAdministratorName != null) {
			document.addField("accountAdministratorName_indexed_string", accountAdministratorName);
			document.addField("accountAdministratorName_stored_string", accountAdministratorName);
		}
		if(accountLocation != null) {
			document.addField("accountLocation_indexed_string", accountLocation);
			document.addField("accountLocation_stored_string", accountLocation);
		}
		if(accountAddress != null) {
			document.addField("accountAddress_indexed_string", accountAddress);
			document.addField("accountAddress_stored_string", accountAddress);
		}
		if(objectSuggest != null) {
			document.addField("objectSuggest_suggested", objectSuggest);
		}
		if(accountShortName != null) {
			document.addField("accountShortName_indexed_string", accountShortName);
			document.addField("accountShortName_stored_string", accountShortName);
		}
		if(accountCompleteName != null) {
			document.addField("accountCompleteName_indexed_string", accountCompleteName);
			document.addField("accountCompleteName_stored_string", accountCompleteName);
		}
		if(accountId != null) {
			document.addField("accountId_indexed_string", accountId);
			document.addField("accountId_stored_string", accountId);
		}
		if(pageUrl != null) {
			document.addField("pageUrl_indexed_string", pageUrl);
			document.addField("pageUrl_stored_string", pageUrl);
		}
		super.indexCluster(document);

	}

	public void unindexBankAccount() {
		try {
		SiteRequestEnUS siteRequest = new SiteRequestEnUS();
			siteRequest.initDeepSiteRequestEnUS();
			SiteContextEnUS siteContext = new SiteContextEnUS();
			siteContext.initDeepSiteContextEnUS();
			siteRequest.setSiteContext_(siteContext);
			siteRequest.setSiteConfig_(siteContext.getSiteConfig());
			initDeepBankAccount(siteRequest);
			SolrClient solrClient = siteContext.getSolrClient();
			solrClient.deleteById(id.toString());
			solrClient.commit(false, false, true);
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public static String varIndexedBankAccount(String entityVar) {
		switch(entityVar) {
			case "accountKey":
				return "accountKey_indexed_long";
			case "yearKeys":
				return "yearKeys_indexed_longs";
			case "accountNumber":
				return "accountNumber_indexed_string";
			case "accountPhoneNumber":
				return "accountPhoneNumber_indexed_string";
			case "accountAdministratorName":
				return "accountAdministratorName_indexed_string";
			case "accountLocation":
				return "accountLocation_indexed_string";
			case "accountAddress":
				return "accountAddress_indexed_string";
			case "objectSuggest":
				return "objectSuggest_indexed_string";
			case "accountShortName":
				return "accountShortName_indexed_string";
			case "accountCompleteName":
				return "accountCompleteName_indexed_string";
			case "accountId":
				return "accountId_indexed_string";
			case "pageUrl":
				return "pageUrl_indexed_string";
			default:
				return Cluster.varIndexedCluster(entityVar);
		}
	}

	public static String varSearchBankAccount(String entityVar) {
		switch(entityVar) {
			case "objectSuggest":
				return "objectSuggest_suggested";
			default:
				return Cluster.varSearchCluster(entityVar);
		}
	}

	public static String varSuggestBankAccount(String entityVar) {
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
		storeBankAccount(solrDocument);
	}
	public void storeBankAccount(SolrDocument solrDocument) {
		BankAccount oBankAccount = (BankAccount)this;

		Long accountKey = (Long)solrDocument.get("accountKey_stored_long");
		if(accountKey != null)
			oBankAccount.setAccountKey(accountKey);

		List<Long> yearKeys = (List<Long>)solrDocument.get("yearKeys_stored_longs");
		if(yearKeys != null)
			oBankAccount.yearKeys.addAll(yearKeys);

		String accountNumber = (String)solrDocument.get("accountNumber_stored_string");
		if(accountNumber != null)
			oBankAccount.setAccountNumber(accountNumber);

		String accountPhoneNumber = (String)solrDocument.get("accountPhoneNumber_stored_string");
		if(accountPhoneNumber != null)
			oBankAccount.setAccountPhoneNumber(accountPhoneNumber);

		String accountAdministratorName = (String)solrDocument.get("accountAdministratorName_stored_string");
		if(accountAdministratorName != null)
			oBankAccount.setAccountAdministratorName(accountAdministratorName);

		String accountLocation = (String)solrDocument.get("accountLocation_stored_string");
		if(accountLocation != null)
			oBankAccount.setAccountLocation(accountLocation);

		String accountAddress = (String)solrDocument.get("accountAddress_stored_string");
		if(accountAddress != null)
			oBankAccount.setAccountAddress(accountAddress);

		String objectSuggest = (String)solrDocument.get("objectSuggest_suggested");
		oBankAccount.setObjectSuggest(objectSuggest);

		String accountShortName = (String)solrDocument.get("accountShortName_stored_string");
		if(accountShortName != null)
			oBankAccount.setAccountShortName(accountShortName);

		String accountCompleteName = (String)solrDocument.get("accountCompleteName_stored_string");
		if(accountCompleteName != null)
			oBankAccount.setAccountCompleteName(accountCompleteName);

		String accountId = (String)solrDocument.get("accountId_stored_string");
		if(accountId != null)
			oBankAccount.setAccountId(accountId);

		String pageUrl = (String)solrDocument.get("pageUrl_stored_string");
		if(pageUrl != null)
			oBankAccount.setPageUrl(pageUrl);

		super.storeCluster(solrDocument);
	}

	//////////////
	// htmlBody //
	//////////////

	public void htmlBody() {
		htmlBodyBankAccount();
	}

	public void htmlBodyBankAccount() {
	}

	//////////////////
	// patchRequest //
	//////////////////

	public void patchRequestBankAccount() {
		PatchRequest patchRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getPatchRequest_).orElse(null);
		BankAccount original = (BankAccount)Optional.ofNullable(patchRequest).map(PatchRequest::getOriginal).orElse(null);
		if(original != null) {
			if(!Objects.equals(accountNumber, original.getAccountNumber()))
				patchRequest.addVars("accountNumber");
			if(!Objects.equals(accountPhoneNumber, original.getAccountPhoneNumber()))
				patchRequest.addVars("accountPhoneNumber");
			if(!Objects.equals(accountAdministratorName, original.getAccountAdministratorName()))
				patchRequest.addVars("accountAdministratorName");
			if(!Objects.equals(accountLocation, original.getAccountLocation()))
				patchRequest.addVars("accountLocation");
			if(!Objects.equals(accountAddress, original.getAccountAddress()))
				patchRequest.addVars("accountAddress");
			super.patchRequestCluster();
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(super.hashCode(), accountNumber, accountPhoneNumber, accountAdministratorName, accountLocation, accountAddress);
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof BankAccount))
			return false;
		BankAccount that = (BankAccount)o;
		return super.equals(o)
				&& Objects.equals( accountNumber, that.accountNumber )
				&& Objects.equals( accountPhoneNumber, that.accountPhoneNumber )
				&& Objects.equals( accountAdministratorName, that.accountAdministratorName )
				&& Objects.equals( accountLocation, that.accountLocation )
				&& Objects.equals( accountAddress, that.accountAddress );
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("BankAccount { ");
		sb.append( "accountNumber: \"" ).append(accountNumber).append( "\"" );
		sb.append( ", accountPhoneNumber: \"" ).append(accountPhoneNumber).append( "\"" );
		sb.append( ", accountAdministratorName: \"" ).append(accountAdministratorName).append( "\"" );
		sb.append( ", accountLocation: \"" ).append(accountLocation).append( "\"" );
		sb.append( ", accountAddress: \"" ).append(accountAddress).append( "\"" );
		sb.append(" }");
		return sb.toString();
	}
}
