package org.computate.bancaire.enus.account;

import org.computate.bancaire.enus.writer.AllWriter;
import org.computate.bancaire.enus.search.SearchList;
import org.computate.bancaire.enus.cluster.Cluster;
import org.computate.bancaire.enus.cluster.ClusterPage;
import java.math.MathContext;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.computate.bancaire.enus.account.BankAccount;
import java.text.NumberFormat;
import java.util.Objects;
import io.vertx.core.json.JsonArray;
import org.computate.bancaire.enus.wrap.Wrap;
import org.computate.bancaire.enus.request.SiteRequestEnUS;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import org.computate.bancaire.enus.request.patch.PatchRequest;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.account.AccountGenPage&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class AccountGenPageGen<DEV> extends ClusterPage {

	/////////////////////
	// listBankAccount //
	/////////////////////

	/**	L'entité « listBankAccount »
	 *	 is defined as null before being initialized. 
	 */
	protected SearchList<BankAccount> listBankAccount;
	@JsonIgnore
	public Wrap<SearchList<BankAccount>> listBankAccountWrap = new Wrap<SearchList<BankAccount>>().p(this).c(SearchList.class).var("listBankAccount").o(listBankAccount);

	/**	<br/>L'entité « listBankAccount »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.account.AccountGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:listBankAccount">Trouver l'entité listBankAccount dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _listBankAccount(Wrap<SearchList<BankAccount>> c);

	public SearchList<BankAccount> getListBankAccount() {
		return listBankAccount;
	}

	public void setListBankAccount(SearchList<BankAccount> listBankAccount) {
		this.listBankAccount = listBankAccount;
		this.listBankAccountWrap.alreadyInitialized = true;
	}
	protected AccountGenPage listBankAccountInit() {
		if(!listBankAccountWrap.alreadyInitialized) {
			_listBankAccount(listBankAccountWrap);
			if(listBankAccount == null)
				setListBankAccount(listBankAccountWrap.o);
		}
		if(listBankAccount != null)
			listBankAccount.initDeepForClass(null);
		listBankAccountWrap.alreadyInitialized(true);
		return (AccountGenPage)this;
	}

	/////////////////
	// bankAccount //
	/////////////////

	/**	L'entité « bankAccount »
	 *	 is defined as null before being initialized. 
	 */
	protected BankAccount bankAccount;
	@JsonIgnore
	public Wrap<BankAccount> bankAccountWrap = new Wrap<BankAccount>().p(this).c(BankAccount.class).var("bankAccount").o(bankAccount);

	/**	<br/>L'entité « bankAccount »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.account.AccountGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:bankAccount">Trouver l'entité bankAccount dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _bankAccount(Wrap<BankAccount> c);

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
		this.bankAccountWrap.alreadyInitialized = true;
	}
	protected AccountGenPage bankAccountInit() {
		if(!bankAccountWrap.alreadyInitialized) {
			_bankAccount(bankAccountWrap);
			if(bankAccount == null)
				setBankAccount(bankAccountWrap.o);
		}
		if(bankAccount != null)
			bankAccount.initDeepForClass(null);
		bankAccountWrap.alreadyInitialized(true);
		return (AccountGenPage)this;
	}

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedAccountGenPage = false;

	public AccountGenPage initDeepAccountGenPage(SiteRequestEnUS siteRequest_) {
		if(!alreadyInitializedAccountGenPage) {
			alreadyInitializedAccountGenPage = true;
			initDeepAccountGenPage();
		}
		return (AccountGenPage)this;
	}

	public void initDeepAccountGenPage() {
		initAccountGenPage();
		super.initDeepClusterPage(siteRequest_);
	}

	public void initAccountGenPage() {
		listBankAccountInit();
		bankAccountInit();
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepAccountGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainAccountGenPage(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainAccountGenPage(String var) {
		AccountGenPage oAccountGenPage = (AccountGenPage)this;
		switch(var) {
			case "listBankAccount":
				return oAccountGenPage.listBankAccount;
			case "bankAccount":
				return oAccountGenPage.bankAccount;
			default:
				return super.obtainClusterPage(var);
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
				o = attributeAccountGenPage(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeAccountGenPage(String var, Object val) {
		AccountGenPage oAccountGenPage = (AccountGenPage)this;
		switch(var) {
			default:
				return super.attributeClusterPage(var, val);
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
					o = defineAccountGenPage(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineAccountGenPage(String var, String val) {
		switch(var) {
			default:
				return super.defineClusterPage(var, val);
		}
	}

	/////////////////
	// htmlScripts //
	/////////////////

	@Override public void htmlScripts() {
		htmlScriptsAccountGenPage();
		super.htmlScripts();
	}

	public void htmlScriptsAccountGenPage() {
	}

	////////////////
	// htmlScript //
	////////////////

	@Override public void htmlScript() {
		htmlScriptAccountGenPage();
		super.htmlScript();
	}

	public void htmlScriptAccountGenPage() {
	}

	//////////////
	// htmlBody //
	//////////////

	@Override public void htmlBody() {
		htmlBodyAccountGenPage();
		super.htmlBody();
	}

	public void htmlBodyAccountGenPage() {
	}

	//////////
	// html //
	//////////

	@Override public void html() {
		htmlAccountGenPage();
		super.html();
	}

	public void htmlAccountGenPage() {
	}

	//////////////
	// htmlMeta //
	//////////////

	@Override public void htmlMeta() {
		htmlMetaAccountGenPage();
		super.htmlMeta();
	}

	public void htmlMetaAccountGenPage() {
	}

	////////////////
	// htmlStyles //
	////////////////

	@Override public void htmlStyles() {
		htmlStylesAccountGenPage();
		super.htmlStyles();
	}

	public void htmlStylesAccountGenPage() {
	}

	///////////////
	// htmlStyle //
	///////////////

	@Override public void htmlStyle() {
		htmlStyleAccountGenPage();
		super.htmlStyle();
	}

	public void htmlStyleAccountGenPage() {
	}

	//////////////////
	// patchRequest //
	//////////////////

	public void patchRequestAccountGenPage() {
		PatchRequest patchRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getPatchRequest_).orElse(null);
		AccountGenPage original = (AccountGenPage)Optional.ofNullable(patchRequest).map(PatchRequest::getOriginal).orElse(null);
		if(original != null) {
			super.patchRequestClusterPage();
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(super.hashCode());
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof AccountGenPage))
			return false;
		AccountGenPage that = (AccountGenPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("AccountGenPage { ");
		sb.append(" }");
		return sb.toString();
	}
}
