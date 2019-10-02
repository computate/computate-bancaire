package org.computate.bancaire.enus.transaction;

import org.computate.bancaire.enus.writer.AllWriter;
import org.computate.bancaire.enus.cluster.Cluster;
import java.math.MathContext;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import java.text.NumberFormat;
import java.util.Objects;
import org.computate.bancaire.enus.transaction.TransactionGenPage;
import io.vertx.core.json.JsonArray;
import org.computate.bancaire.enus.wrap.Wrap;
import org.computate.bancaire.enus.request.SiteRequestEnUS;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.math.NumberUtils;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.TransactionPage&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class TransactionPageGen<DEV> extends TransactionGenPage {

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedTransactionPage = false;

	public TransactionPage initDeepTransactionPage(SiteRequestEnUS siteRequest_) {
		if(!alreadyInitializedTransactionPage) {
			alreadyInitializedTransactionPage = true;
			initDeepTransactionPage();
		}
		return (TransactionPage)this;
	}

	public void initDeepTransactionPage() {
		super.initDeepTransactionGenPage(siteRequest_);
		initTransactionPage();
	}

	public void initTransactionPage() {
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepTransactionPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainTransactionPage(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainTransactionPage(String var) {
		TransactionPage oTransactionPage = (TransactionPage)this;
		switch(var) {
			default:
				return super.obtainTransactionGenPage(var);
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
				o = attributeTransactionPage(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeTransactionPage(String var, Object val) {
		TransactionPage oTransactionPage = (TransactionPage)this;
		switch(var) {
			default:
				return super.attributeTransactionGenPage(var, val);
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
					o = defineTransactionPage(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineTransactionPage(String var, String val) {
		switch(var) {
			default:
				return super.defineTransactionGenPage(var, val);
		}
	}

	/////////////////
	// htmlScripts //
	/////////////////

	@Override public void htmlScripts() {
		htmlScriptsTransactionPage();
		super.htmlScripts();
	}

	public void htmlScriptsTransactionPage() {
	}

	////////////////
	// htmlScript //
	////////////////

	@Override public void htmlScript() {
		htmlScriptTransactionPage();
		super.htmlScript();
	}

	public void htmlScriptTransactionPage() {
	}

	//////////////
	// htmlBody //
	//////////////

	@Override public void htmlBody() {
		htmlBodyTransactionPage();
		super.htmlBody();
	}

	public void htmlBodyTransactionPage() {
	}

	//////////
	// html //
	//////////

	@Override public void html() {
		htmlTransactionPage();
		super.html();
	}

	public void htmlTransactionPage() {
	}

	//////////////
	// htmlMeta //
	//////////////

	@Override public void htmlMeta() {
		htmlMetaTransactionPage();
		super.htmlMeta();
	}

	public void htmlMetaTransactionPage() {
	}

	////////////////
	// htmlStyles //
	////////////////

	@Override public void htmlStyles() {
		htmlStylesTransactionPage();
		super.htmlStyles();
	}

	public void htmlStylesTransactionPage() {
	}

	///////////////
	// htmlStyle //
	///////////////

	@Override public void htmlStyle() {
		htmlStyleTransactionPage();
		super.htmlStyle();
	}

	public void htmlStyleTransactionPage() {
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
		if(!(o instanceof TransactionPage))
			return false;
		TransactionPage that = (TransactionPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("TransactionPage { ");
		sb.append(" }");
		return sb.toString();
	}
}
