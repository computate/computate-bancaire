package org.computate.bancaire.enUS.html.part;

import org.computate.bancaire.enus.writer.AllWriter;
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
import java.util.Optional;
import org.computate.bancaire.enus.request.patch.PatchRequest;
import org.computate.bancaire.enUS.html.part.HtmlPartGenPage;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enUS.html.part.HtmlPartPage&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class HtmlPartPageGen<DEV> extends HtmlPartGenPage {

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedHtmlPartPage = false;

	public HtmlPartPage initDeepHtmlPartPage(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedHtmlPartPage) {
			alreadyInitializedHtmlPartPage = true;
			initDeepHtmlPartPage();
		}
		return (HtmlPartPage)this;
	}

	public void initDeepHtmlPartPage() {
		initHtmlPartPage();
		super.initDeepHtmlPartGenPage(siteRequest_);
	}

	public void initHtmlPartPage() {
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepHtmlPartPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestHtmlPartPage(SiteRequestEnUS siteRequest_) {
			super.siteRequestHtmlPartGenPage(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestHtmlPartPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainHtmlPartPage(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainHtmlPartPage(String var) {
		HtmlPartPage oHtmlPartPage = (HtmlPartPage)this;
		switch(var) {
			default:
				return super.obtainHtmlPartGenPage(var);
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
				o = attributeHtmlPartPage(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeHtmlPartPage(String var, Object val) {
		HtmlPartPage oHtmlPartPage = (HtmlPartPage)this;
		switch(var) {
			default:
				return super.attributeHtmlPartGenPage(var, val);
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
					o = defineHtmlPartPage(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineHtmlPartPage(String var, String val) {
		switch(var) {
			default:
				return super.defineHtmlPartGenPage(var, val);
		}
	}

	/////////////////
	// htmlScripts //
	/////////////////

	@Override public void htmlScripts() {
		htmlScriptsHtmlPartPage();
		super.htmlScripts();
	}

	public void htmlScriptsHtmlPartPage() {
	}

	////////////////
	// htmlScript //
	////////////////

	@Override public void htmlScript() {
		htmlScriptHtmlPartPage();
		super.htmlScript();
	}

	public void htmlScriptHtmlPartPage() {
	}

	//////////////
	// htmlBody //
	//////////////

	@Override public void htmlBody() {
		htmlBodyHtmlPartPage();
		super.htmlBody();
	}

	public void htmlBodyHtmlPartPage() {
	}

	//////////
	// html //
	//////////

	@Override public void html() {
		htmlHtmlPartPage();
		super.html();
	}

	public void htmlHtmlPartPage() {
	}

	//////////////
	// htmlMeta //
	//////////////

	@Override public void htmlMeta() {
		htmlMetaHtmlPartPage();
		super.htmlMeta();
	}

	public void htmlMetaHtmlPartPage() {
	}

	////////////////
	// htmlStyles //
	////////////////

	@Override public void htmlStyles() {
		htmlStylesHtmlPartPage();
		super.htmlStyles();
	}

	public void htmlStylesHtmlPartPage() {
	}

	///////////////
	// htmlStyle //
	///////////////

	@Override public void htmlStyle() {
		htmlStyleHtmlPartPage();
		super.htmlStyle();
	}

	public void htmlStyleHtmlPartPage() {
	}

	//////////////////
	// patchRequest //
	//////////////////

	public void patchRequestHtmlPartPage() {
		PatchRequest patchRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getPatchRequest_).orElse(null);
		HtmlPartPage original = (HtmlPartPage)Optional.ofNullable(patchRequest).map(PatchRequest::getOriginal).orElse(null);
		if(original != null) {
			super.patchRequestHtmlPartGenPage();
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
		if(!(o instanceof HtmlPartPage))
			return false;
		HtmlPartPage that = (HtmlPartPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("HtmlPartPage { ");
		sb.append(" }");
		return sb.toString();
	}
}
