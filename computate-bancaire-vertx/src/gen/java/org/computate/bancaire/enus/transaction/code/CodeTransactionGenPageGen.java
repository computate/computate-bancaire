package org.computate.bancaire.enus.transaction.code;

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
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.math.NumberUtils;
import org.computate.bancaire.enus.transaction.code.TransactionCode;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.code.CodeTransactionGenPage&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class CodeTransactionGenPageGen<DEV> extends ClusterPage {

	/////////////////////////
	// listTransactionCode //
	/////////////////////////

	/**	L'entité « listTransactionCode »
	 *	 is defined as null before being initialized. 
	 */
	protected SearchList<TransactionCode> listTransactionCode;
	@JsonIgnore
	public Wrap<SearchList<TransactionCode>> listTransactionCodeWrap = new Wrap<SearchList<TransactionCode>>().p(this).c(SearchList.class).var("listTransactionCode").o(listTransactionCode);

	/**	<br/>L'entité « listTransactionCode »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.code.CodeTransactionGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:listTransactionCode">Trouver l'entité listTransactionCode dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _listTransactionCode(Wrap<SearchList<TransactionCode>> c);

	public SearchList<TransactionCode> getListTransactionCode() {
		return listTransactionCode;
	}

	public void setListTransactionCode(SearchList<TransactionCode> listTransactionCode) {
		this.listTransactionCode = listTransactionCode;
		this.listTransactionCodeWrap.alreadyInitialized = true;
	}
	protected CodeTransactionGenPage listTransactionCodeInit() {
		if(!listTransactionCodeWrap.alreadyInitialized) {
			_listTransactionCode(listTransactionCodeWrap);
			if(listTransactionCode == null)
				setListTransactionCode(listTransactionCodeWrap.o);
		}
		listTransactionCodeWrap.alreadyInitialized(true);
		return (CodeTransactionGenPage)this;
	}

	/////////////////////
	// transactionCode //
	/////////////////////

	/**	L'entité « transactionCode »
	 *	 is defined as null before being initialized. 
	 */
	protected TransactionCode transactionCode;
	@JsonIgnore
	public Wrap<TransactionCode> transactionCodeWrap = new Wrap<TransactionCode>().p(this).c(TransactionCode.class).var("transactionCode").o(transactionCode);

	/**	<br/>L'entité « transactionCode »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.code.CodeTransactionGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:transactionCode">Trouver l'entité transactionCode dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _transactionCode(Wrap<TransactionCode> c);

	public TransactionCode getTransactionCode() {
		return transactionCode;
	}

	public void setTransactionCode(TransactionCode transactionCode) {
		this.transactionCode = transactionCode;
		this.transactionCodeWrap.alreadyInitialized = true;
	}
	protected CodeTransactionGenPage transactionCodeInit() {
		if(!transactionCodeWrap.alreadyInitialized) {
			_transactionCode(transactionCodeWrap);
			if(transactionCode == null)
				setTransactionCode(transactionCodeWrap.o);
		}
		transactionCodeWrap.alreadyInitialized(true);
		return (CodeTransactionGenPage)this;
	}

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedCodeTransactionGenPage = false;

	public CodeTransactionGenPage initDeepCodeTransactionGenPage(SiteRequestEnUS siteRequest_) {
		if(!alreadyInitializedCodeTransactionGenPage) {
			alreadyInitializedCodeTransactionGenPage = true;
			initDeepCodeTransactionGenPage();
		}
		return (CodeTransactionGenPage)this;
	}

	public void initDeepCodeTransactionGenPage() {
		super.initDeepClusterPage(siteRequest_);
		initCodeTransactionGenPage();
	}

	public void initCodeTransactionGenPage() {
		listTransactionCodeInit();
		transactionCodeInit();
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepCodeTransactionGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainCodeTransactionGenPage(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainCodeTransactionGenPage(String var) {
		CodeTransactionGenPage oCodeTransactionGenPage = (CodeTransactionGenPage)this;
		switch(var) {
			case "listTransactionCode":
				return oCodeTransactionGenPage.listTransactionCode;
			case "transactionCode":
				return oCodeTransactionGenPage.transactionCode;
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
				o = attributeCodeTransactionGenPage(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeCodeTransactionGenPage(String var, Object val) {
		CodeTransactionGenPage oCodeTransactionGenPage = (CodeTransactionGenPage)this;
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
					o = defineCodeTransactionGenPage(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineCodeTransactionGenPage(String var, String val) {
		switch(var) {
			default:
				return super.defineClusterPage(var, val);
		}
	}

	/////////////////
	// htmlScripts //
	/////////////////

	public void htmlScripts() {
		htmlScriptsCodeTransactionGenPage();
	}

	public void htmlScriptsCodeTransactionGenPage() {
	}

	////////////////
	// htmlScript //
	////////////////

	public void htmlScript() {
		htmlScriptCodeTransactionGenPage();
	}

	public void htmlScriptCodeTransactionGenPage() {
	}

	//////////////
	// htmlBody //
	//////////////

	public void htmlBody() {
		htmlBodyCodeTransactionGenPage();
	}

	public void htmlBodyCodeTransactionGenPage() {
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
		if(!(o instanceof CodeTransactionGenPage))
			return false;
		CodeTransactionGenPage that = (CodeTransactionGenPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("CodeTransactionGenPage { ");
		sb.append(" }");
		return sb.toString();
	}
}
