package org.computate.bancaire.enus.adjustment;

import org.computate.bancaire.enus.writer.AllWriter;
import org.computate.bancaire.enus.search.SearchList;
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
import org.computate.bancaire.enus.adjustment.BankAdjustment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import org.computate.bancaire.enus.request.patch.PatchRequest;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.adjustment.AdjustmentGenPage&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class AdjustmentGenPageGen<DEV> extends ClusterPage {

	////////////////////////
	// listBankAdjustment //
	////////////////////////

	/**	L'entité « listBankAdjustment »
	 *	 is defined as null before being initialized. 
	 */
	protected SearchList<BankAdjustment> listBankAdjustment;
	@JsonIgnore
	public Wrap<SearchList<BankAdjustment>> listBankAdjustmentWrap = new Wrap<SearchList<BankAdjustment>>().p(this).c(SearchList.class).var("listBankAdjustment").o(listBankAdjustment);

	/**	<br/>L'entité « listBankAdjustment »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.adjustment.AdjustmentGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:listBankAdjustment">Trouver l'entité listBankAdjustment dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _listBankAdjustment(Wrap<SearchList<BankAdjustment>> c);

	public SearchList<BankAdjustment> getListBankAdjustment() {
		return listBankAdjustment;
	}

	public void setListBankAdjustment(SearchList<BankAdjustment> listBankAdjustment) {
		this.listBankAdjustment = listBankAdjustment;
		this.listBankAdjustmentWrap.alreadyInitialized = true;
	}
	protected AdjustmentGenPage listBankAdjustmentInit() {
		if(!listBankAdjustmentWrap.alreadyInitialized) {
			_listBankAdjustment(listBankAdjustmentWrap);
			if(listBankAdjustment == null)
				setListBankAdjustment(listBankAdjustmentWrap.o);
		}
		if(listBankAdjustment != null)
			listBankAdjustment.initDeepForClass(null);
		listBankAdjustmentWrap.alreadyInitialized(true);
		return (AdjustmentGenPage)this;
	}

	////////////////////
	// bankAdjustment //
	////////////////////

	/**	L'entité « bankAdjustment »
	 *	 is defined as null before being initialized. 
	 */
	protected BankAdjustment bankAdjustment;
	@JsonIgnore
	public Wrap<BankAdjustment> bankAdjustmentWrap = new Wrap<BankAdjustment>().p(this).c(BankAdjustment.class).var("bankAdjustment").o(bankAdjustment);

	/**	<br/>L'entité « bankAdjustment »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.adjustment.AdjustmentGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:bankAdjustment">Trouver l'entité bankAdjustment dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _bankAdjustment(Wrap<BankAdjustment> c);

	public BankAdjustment getBankAdjustment() {
		return bankAdjustment;
	}

	public void setBankAdjustment(BankAdjustment bankAdjustment) {
		this.bankAdjustment = bankAdjustment;
		this.bankAdjustmentWrap.alreadyInitialized = true;
	}
	protected AdjustmentGenPage bankAdjustmentInit() {
		if(!bankAdjustmentWrap.alreadyInitialized) {
			_bankAdjustment(bankAdjustmentWrap);
			if(bankAdjustment == null)
				setBankAdjustment(bankAdjustmentWrap.o);
		}
		if(bankAdjustment != null)
			bankAdjustment.initDeepForClass(null);
		bankAdjustmentWrap.alreadyInitialized(true);
		return (AdjustmentGenPage)this;
	}

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedAdjustmentGenPage = false;

	public AdjustmentGenPage initDeepAdjustmentGenPage(SiteRequestEnUS siteRequest_) {
		if(!alreadyInitializedAdjustmentGenPage) {
			alreadyInitializedAdjustmentGenPage = true;
			initDeepAdjustmentGenPage();
		}
		return (AdjustmentGenPage)this;
	}

	public void initDeepAdjustmentGenPage() {
		initAdjustmentGenPage();
		super.initDeepClusterPage(siteRequest_);
	}

	public void initAdjustmentGenPage() {
		listBankAdjustmentInit();
		bankAdjustmentInit();
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepAdjustmentGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainAdjustmentGenPage(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainAdjustmentGenPage(String var) {
		AdjustmentGenPage oAdjustmentGenPage = (AdjustmentGenPage)this;
		switch(var) {
			case "listBankAdjustment":
				return oAdjustmentGenPage.listBankAdjustment;
			case "bankAdjustment":
				return oAdjustmentGenPage.bankAdjustment;
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
				o = attributeAdjustmentGenPage(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeAdjustmentGenPage(String var, Object val) {
		AdjustmentGenPage oAdjustmentGenPage = (AdjustmentGenPage)this;
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
					o = defineAdjustmentGenPage(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineAdjustmentGenPage(String var, String val) {
		switch(var) {
			default:
				return super.defineClusterPage(var, val);
		}
	}

	/////////////////
	// htmlScripts //
	/////////////////

	@Override public void htmlScripts() {
		htmlScriptsAdjustmentGenPage();
		super.htmlScripts();
	}

	public void htmlScriptsAdjustmentGenPage() {
	}

	////////////////
	// htmlScript //
	////////////////

	@Override public void htmlScript() {
		htmlScriptAdjustmentGenPage();
		super.htmlScript();
	}

	public void htmlScriptAdjustmentGenPage() {
	}

	//////////////
	// htmlBody //
	//////////////

	@Override public void htmlBody() {
		htmlBodyAdjustmentGenPage();
		super.htmlBody();
	}

	public void htmlBodyAdjustmentGenPage() {
	}

	//////////
	// html //
	//////////

	@Override public void html() {
		htmlAdjustmentGenPage();
		super.html();
	}

	public void htmlAdjustmentGenPage() {
	}

	//////////////
	// htmlMeta //
	//////////////

	@Override public void htmlMeta() {
		htmlMetaAdjustmentGenPage();
		super.htmlMeta();
	}

	public void htmlMetaAdjustmentGenPage() {
	}

	////////////////
	// htmlStyles //
	////////////////

	@Override public void htmlStyles() {
		htmlStylesAdjustmentGenPage();
		super.htmlStyles();
	}

	public void htmlStylesAdjustmentGenPage() {
	}

	///////////////
	// htmlStyle //
	///////////////

	@Override public void htmlStyle() {
		htmlStyleAdjustmentGenPage();
		super.htmlStyle();
	}

	public void htmlStyleAdjustmentGenPage() {
	}

	//////////////////
	// patchRequest //
	//////////////////

	public void patchRequestAdjustmentGenPage() {
		PatchRequest patchRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getPatchRequest_).orElse(null);
		AdjustmentGenPage original = (AdjustmentGenPage)Optional.ofNullable(patchRequest).map(PatchRequest::getOriginal).orElse(null);
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
		if(!(o instanceof AdjustmentGenPage))
			return false;
		AdjustmentGenPage that = (AdjustmentGenPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("AdjustmentGenPage { ");
		sb.append(" }");
		return sb.toString();
	}
}
