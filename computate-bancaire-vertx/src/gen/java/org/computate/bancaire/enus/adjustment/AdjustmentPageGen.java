package org.computate.bancaire.enus.adjustment;

import org.computate.bancaire.enus.writer.AllWriter;
import org.computate.bancaire.enus.adjustment.AdjustmentGenPage;
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

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.adjustment.AdjustmentPage&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class AdjustmentPageGen<DEV> extends AdjustmentGenPage {

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedAdjustmentPage = false;

	public AdjustmentPage initDeepAdjustmentPage(SiteRequestEnUS siteRequest_) {
		if(!alreadyInitializedAdjustmentPage) {
			alreadyInitializedAdjustmentPage = true;
			initDeepAdjustmentPage();
		}
		return (AdjustmentPage)this;
	}

	public void initDeepAdjustmentPage() {
		initAdjustmentPage();
		super.initDeepAdjustmentGenPage(siteRequest_);
	}

	public void initAdjustmentPage() {
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepAdjustmentPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainAdjustmentPage(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainAdjustmentPage(String var) {
		AdjustmentPage oAdjustmentPage = (AdjustmentPage)this;
		switch(var) {
			default:
				return super.obtainAdjustmentGenPage(var);
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
				o = attributeAdjustmentPage(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeAdjustmentPage(String var, Object val) {
		AdjustmentPage oAdjustmentPage = (AdjustmentPage)this;
		switch(var) {
			default:
				return super.attributeAdjustmentGenPage(var, val);
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
					o = defineAdjustmentPage(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineAdjustmentPage(String var, String val) {
		switch(var) {
			default:
				return super.defineAdjustmentGenPage(var, val);
		}
	}

	/////////////////
	// htmlScripts //
	/////////////////

	@Override public void htmlScripts() {
		htmlScriptsAdjustmentPage();
		super.htmlScripts();
	}

	public void htmlScriptsAdjustmentPage() {
	}

	////////////////
	// htmlScript //
	////////////////

	@Override public void htmlScript() {
		htmlScriptAdjustmentPage();
		super.htmlScript();
	}

	public void htmlScriptAdjustmentPage() {
	}

	//////////////
	// htmlBody //
	//////////////

	@Override public void htmlBody() {
		htmlBodyAdjustmentPage();
		super.htmlBody();
	}

	public void htmlBodyAdjustmentPage() {
	}

	//////////
	// html //
	//////////

	@Override public void html() {
		htmlAdjustmentPage();
		super.html();
	}

	public void htmlAdjustmentPage() {
	}

	//////////////
	// htmlMeta //
	//////////////

	@Override public void htmlMeta() {
		htmlMetaAdjustmentPage();
		super.htmlMeta();
	}

	public void htmlMetaAdjustmentPage() {
	}

	////////////////
	// htmlStyles //
	////////////////

	@Override public void htmlStyles() {
		htmlStylesAdjustmentPage();
		super.htmlStyles();
	}

	public void htmlStylesAdjustmentPage() {
	}

	///////////////
	// htmlStyle //
	///////////////

	@Override public void htmlStyle() {
		htmlStyleAdjustmentPage();
		super.htmlStyle();
	}

	public void htmlStyleAdjustmentPage() {
	}

	//////////////////
	// patchRequest //
	//////////////////

	public void patchRequestAdjustmentPage() {
		PatchRequest patchRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getPatchRequest_).orElse(null);
		AdjustmentPage original = (AdjustmentPage)Optional.ofNullable(patchRequest).map(PatchRequest::getOriginal).orElse(null);
		if(original != null) {
			super.patchRequestAdjustmentGenPage();
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
		if(!(o instanceof AdjustmentPage))
			return false;
		AdjustmentPage that = (AdjustmentPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("AdjustmentPage { ");
		sb.append(" }");
		return sb.toString();
	}
}
