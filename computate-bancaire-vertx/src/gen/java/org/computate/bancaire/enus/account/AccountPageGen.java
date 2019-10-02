package org.computate.bancaire.enus.account;

import org.computate.bancaire.enus.writer.AllWriter;
import org.computate.bancaire.enus.account.AccountGenPage;
import org.computate.bancaire.enus.cluster.Cluster;
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

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.account.AccountPage&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class AccountPageGen<DEV> extends AccountGenPage {

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedAccountPage = false;

	public AccountPage initDeepAccountPage(SiteRequestEnUS siteRequest_) {
		if(!alreadyInitializedAccountPage) {
			alreadyInitializedAccountPage = true;
			initDeepAccountPage();
		}
		return (AccountPage)this;
	}

	public void initDeepAccountPage() {
		super.initDeepAccountGenPage(siteRequest_);
		initAccountPage();
	}

	public void initAccountPage() {
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepAccountPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainAccountPage(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainAccountPage(String var) {
		AccountPage oAccountPage = (AccountPage)this;
		switch(var) {
			default:
				return super.obtainAccountGenPage(var);
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
				o = attributeAccountPage(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeAccountPage(String var, Object val) {
		AccountPage oAccountPage = (AccountPage)this;
		switch(var) {
			default:
				return super.attributeAccountGenPage(var, val);
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
					o = defineAccountPage(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineAccountPage(String var, String val) {
		switch(var) {
			default:
				return super.defineAccountGenPage(var, val);
		}
	}

	/////////////////
	// htmlScripts //
	/////////////////

	@Override public void htmlScripts() {
		htmlScriptsAccountPage();
		super.htmlScripts();
	}

	public void htmlScriptsAccountPage() {
	}

	////////////////
	// htmlScript //
	////////////////

	@Override public void htmlScript() {
		htmlScriptAccountPage();
		super.htmlScript();
	}

	public void htmlScriptAccountPage() {
	}

	//////////////
	// htmlBody //
	//////////////

	@Override public void htmlBody() {
		htmlBodyAccountPage();
		super.htmlBody();
	}

	public void htmlBodyAccountPage() {
	}

	//////////
	// html //
	//////////

	@Override public void html() {
		htmlAccountPage();
		super.html();
	}

	public void htmlAccountPage() {
	}

	//////////////
	// htmlMeta //
	//////////////

	@Override public void htmlMeta() {
		htmlMetaAccountPage();
		super.htmlMeta();
	}

	public void htmlMetaAccountPage() {
	}

	////////////////
	// htmlStyles //
	////////////////

	@Override public void htmlStyles() {
		htmlStylesAccountPage();
		super.htmlStyles();
	}

	public void htmlStylesAccountPage() {
	}

	///////////////
	// htmlStyle //
	///////////////

	@Override public void htmlStyle() {
		htmlStyleAccountPage();
		super.htmlStyle();
	}

	public void htmlStyleAccountPage() {
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
		if(!(o instanceof AccountPage))
			return false;
		AccountPage that = (AccountPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("AccountPage { ");
		sb.append(" }");
		return sb.toString();
	}
}
