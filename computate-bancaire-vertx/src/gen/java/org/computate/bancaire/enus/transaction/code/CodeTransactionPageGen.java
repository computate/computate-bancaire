package org.computate.bancaire.enus.transaction.code;

import org.computate.bancaire.enus.writer.AllWriter;
import org.computate.bancaire.enus.cluster.Cluster;
import java.math.MathContext;
import org.computate.bancaire.enus.transaction.code.CodeTransactionGenPage;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import java.text.NumberFormat;
import java.util.Objects;
import io.vertx.core.json.JsonArray;
import org.computate.bancaire.enus.wrap.Wrap;
import org.computate.bancaire.enus.request.SiteRequestEnUS;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.math.NumberUtils;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.code.CodeTransactionPage&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class CodeTransactionPageGen<DEV> extends CodeTransactionGenPage {

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedCodeTransactionPage = false;

	public CodeTransactionPage initDeepCodeTransactionPage(SiteRequestEnUS siteRequest_) {
		if(!alreadyInitializedCodeTransactionPage) {
			alreadyInitializedCodeTransactionPage = true;
			initDeepCodeTransactionPage();
		}
		return (CodeTransactionPage)this;
	}

	public void initDeepCodeTransactionPage() {
		super.initDeepCodeTransactionGenPage(siteRequest_);
		initCodeTransactionPage();
	}

	public void initCodeTransactionPage() {
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepCodeTransactionPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainCodeTransactionPage(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainCodeTransactionPage(String var) {
		CodeTransactionPage oCodeTransactionPage = (CodeTransactionPage)this;
		switch(var) {
			default:
				return super.obtainCodeTransactionGenPage(var);
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
				o = attributeCodeTransactionPage(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeCodeTransactionPage(String var, Object val) {
		CodeTransactionPage oCodeTransactionPage = (CodeTransactionPage)this;
		switch(var) {
			default:
				return super.attributeCodeTransactionGenPage(var, val);
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
					o = defineCodeTransactionPage(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineCodeTransactionPage(String var, String val) {
		switch(var) {
			default:
				return super.defineCodeTransactionGenPage(var, val);
		}
	}

	/////////////////
	// htmlScripts //
	/////////////////

	@Override public void htmlScripts() {
		htmlScriptsCodeTransactionPage();
		super.htmlScripts();
	}

	public void htmlScriptsCodeTransactionPage() {
	}

	////////////////
	// htmlScript //
	////////////////

	@Override public void htmlScript() {
		htmlScriptCodeTransactionPage();
		super.htmlScript();
	}

	public void htmlScriptCodeTransactionPage() {
	}

	//////////////
	// htmlBody //
	//////////////

	@Override public void htmlBody() {
		htmlBodyCodeTransactionPage();
		super.htmlBody();
	}

	public void htmlBodyCodeTransactionPage() {
	}

	//////////
	// html //
	//////////

	@Override public void html() {
		htmlCodeTransactionPage();
		super.html();
	}

	public void htmlCodeTransactionPage() {
	}

	//////////////
	// htmlMeta //
	//////////////

	@Override public void htmlMeta() {
		htmlMetaCodeTransactionPage();
		super.htmlMeta();
	}

	public void htmlMetaCodeTransactionPage() {
	}

	////////////////
	// htmlStyles //
	////////////////

	@Override public void htmlStyles() {
		htmlStylesCodeTransactionPage();
		super.htmlStyles();
	}

	public void htmlStylesCodeTransactionPage() {
	}

	///////////////
	// htmlStyle //
	///////////////

	@Override public void htmlStyle() {
		htmlStyleCodeTransactionPage();
		super.htmlStyle();
	}

	public void htmlStyleCodeTransactionPage() {
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
		if(!(o instanceof CodeTransactionPage))
			return false;
		CodeTransactionPage that = (CodeTransactionPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("CodeTransactionPage { ");
		sb.append(" }");
		return sb.toString();
	}
}
