package org.computate.bancaire.enus.transaction;

import org.computate.bancaire.enus.writer.AllWriter;
import org.computate.bancaire.enus.search.SearchList;
import org.computate.bancaire.enus.transaction.BankTransaction;
import org.computate.bancaire.enus.cluster.Cluster;
import org.computate.bancaire.enus.cluster.ClusterPage;
import java.math.MathContext;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
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
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.TransactionGenPage&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class TransactionGenPageGen<DEV> extends ClusterPage {

	/////////////////////////
	// listBankTransaction //
	/////////////////////////

	/**	L'entité « listBankTransaction »
	 *	 is defined as null before being initialized. 
	 */
	protected SearchList<BankTransaction> listBankTransaction;
	@JsonIgnore
	public Wrap<SearchList<BankTransaction>> listBankTransactionWrap = new Wrap<SearchList<BankTransaction>>().p(this).c(SearchList.class).var("listBankTransaction").o(listBankTransaction);

	/**	<br/>L'entité « listBankTransaction »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.TransactionGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:listBankTransaction">Trouver l'entité listBankTransaction dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _listBankTransaction(Wrap<SearchList<BankTransaction>> c);

	public SearchList<BankTransaction> getListBankTransaction() {
		return listBankTransaction;
	}

	public void setListBankTransaction(SearchList<BankTransaction> listBankTransaction) {
		this.listBankTransaction = listBankTransaction;
		this.listBankTransactionWrap.alreadyInitialized = true;
	}
	protected TransactionGenPage listBankTransactionInit() {
		if(!listBankTransactionWrap.alreadyInitialized) {
			_listBankTransaction(listBankTransactionWrap);
			if(listBankTransaction == null)
				setListBankTransaction(listBankTransactionWrap.o);
		}
		if(listBankTransaction != null)
			listBankTransaction.initDeepForClass(null);
		listBankTransactionWrap.alreadyInitialized(true);
		return (TransactionGenPage)this;
	}

	/////////////////////
	// bankTransaction //
	/////////////////////

	/**	L'entité « bankTransaction »
	 *	 is defined as null before being initialized. 
	 */
	protected BankTransaction bankTransaction;
	@JsonIgnore
	public Wrap<BankTransaction> bankTransactionWrap = new Wrap<BankTransaction>().p(this).c(BankTransaction.class).var("bankTransaction").o(bankTransaction);

	/**	<br/>L'entité « bankTransaction »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.TransactionGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:bankTransaction">Trouver l'entité bankTransaction dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _bankTransaction(Wrap<BankTransaction> c);

	public BankTransaction getBankTransaction() {
		return bankTransaction;
	}

	public void setBankTransaction(BankTransaction bankTransaction) {
		this.bankTransaction = bankTransaction;
		this.bankTransactionWrap.alreadyInitialized = true;
	}
	protected TransactionGenPage bankTransactionInit() {
		if(!bankTransactionWrap.alreadyInitialized) {
			_bankTransaction(bankTransactionWrap);
			if(bankTransaction == null)
				setBankTransaction(bankTransactionWrap.o);
		}
		if(bankTransaction != null)
			bankTransaction.initDeepForClass(null);
		bankTransactionWrap.alreadyInitialized(true);
		return (TransactionGenPage)this;
	}

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedTransactionGenPage = false;

	public TransactionGenPage initDeepTransactionGenPage(SiteRequestEnUS siteRequest_) {
		if(!alreadyInitializedTransactionGenPage) {
			alreadyInitializedTransactionGenPage = true;
			initDeepTransactionGenPage();
		}
		return (TransactionGenPage)this;
	}

	public void initDeepTransactionGenPage() {
		initTransactionGenPage();
		super.initDeepClusterPage(siteRequest_);
	}

	public void initTransactionGenPage() {
		listBankTransactionInit();
		bankTransactionInit();
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepTransactionGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainTransactionGenPage(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainTransactionGenPage(String var) {
		TransactionGenPage oTransactionGenPage = (TransactionGenPage)this;
		switch(var) {
			case "listBankTransaction":
				return oTransactionGenPage.listBankTransaction;
			case "bankTransaction":
				return oTransactionGenPage.bankTransaction;
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
				o = attributeTransactionGenPage(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeTransactionGenPage(String var, Object val) {
		TransactionGenPage oTransactionGenPage = (TransactionGenPage)this;
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
					o = defineTransactionGenPage(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineTransactionGenPage(String var, String val) {
		switch(var) {
			default:
				return super.defineClusterPage(var, val);
		}
	}

	/////////////////
	// htmlScripts //
	/////////////////

	@Override public void htmlScripts() {
		htmlScriptsTransactionGenPage();
		super.htmlScripts();
	}

	public void htmlScriptsTransactionGenPage() {
	}

	////////////////
	// htmlScript //
	////////////////

	@Override public void htmlScript() {
		htmlScriptTransactionGenPage();
		super.htmlScript();
	}

	public void htmlScriptTransactionGenPage() {
	}

	//////////////
	// htmlBody //
	//////////////

	@Override public void htmlBody() {
		htmlBodyTransactionGenPage();
		super.htmlBody();
	}

	public void htmlBodyTransactionGenPage() {
	}

	//////////
	// html //
	//////////

	@Override public void html() {
		htmlTransactionGenPage();
		super.html();
	}

	public void htmlTransactionGenPage() {
	}

	//////////////
	// htmlMeta //
	//////////////

	@Override public void htmlMeta() {
		htmlMetaTransactionGenPage();
		super.htmlMeta();
	}

	public void htmlMetaTransactionGenPage() {
	}

	////////////////
	// htmlStyles //
	////////////////

	@Override public void htmlStyles() {
		htmlStylesTransactionGenPage();
		super.htmlStyles();
	}

	public void htmlStylesTransactionGenPage() {
	}

	///////////////
	// htmlStyle //
	///////////////

	@Override public void htmlStyle() {
		htmlStyleTransactionGenPage();
		super.htmlStyle();
	}

	public void htmlStyleTransactionGenPage() {
	}

	//////////////////
	// patchRequest //
	//////////////////

	public void patchRequestTransactionGenPage() {
		PatchRequest patchRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getPatchRequest_).orElse(null);
		TransactionGenPage original = (TransactionGenPage)Optional.ofNullable(patchRequest).map(PatchRequest::getOriginal).orElse(null);
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
		if(!(o instanceof TransactionGenPage))
			return false;
		TransactionGenPage that = (TransactionGenPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("TransactionGenPage { ");
		sb.append(" }");
		return sb.toString();
	}
}
