package org.computate.bancaire.enus.page.part;

import org.computate.bancaire.enus.cluster.Cluster;
import java.math.MathContext;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.computate.bancaire.enus.request.SiteRequestEnUS;
import java.text.NumberFormat;
import java.util.Objects;
import org.computate.bancaire.enus.page.PageLayout;
import io.vertx.core.json.JsonArray;
import org.computate.bancaire.enus.wrap.Wrap;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.math.NumberUtils;
import org.computate.bancaire.enus.writer.AllWriter;
import java.lang.String;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.page.part.PagePart&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class PagePartGen<DEV> extends Cluster {

	///////////
	// page_ //
	///////////

	/**	L'entité « page_ »
	 *	 is defined as null before being initialized. 
	 */
	protected PageLayout page_;
	@JsonIgnore
	public Wrap<PageLayout> page_Wrap = new Wrap<PageLayout>().p(this).c(PageLayout.class).var("page_").o(page_);

	/**	<br/>L'entité « page_ »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.page.part.PagePart&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:page_">Trouver l'entité page_ dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _page_(Wrap<PageLayout> c);

	public PageLayout getPage_() {
		return page_;
	}

	public void setPage_(PageLayout page_) {
		this.page_ = page_;
		this.page_Wrap.alreadyInitialized = true;
	}
	protected PagePart page_Init() {
		if(!page_Wrap.alreadyInitialized) {
			_page_(page_Wrap);
			if(page_ == null)
				setPage_(page_Wrap.o);
		}
		page_Wrap.alreadyInitialized(true);
		return (PagePart)this;
	}

	/////////////
	// partVar //
	/////////////

	/**	L'entité « partVar »
	 *	 is defined as null before being initialized. 
	 */
	protected String partVar;
	@JsonIgnore
	public Wrap<String> partVarWrap = new Wrap<String>().p(this).c(String.class).var("partVar").o(partVar);

	/**	<br/>L'entité « partVar »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.page.part.PagePart&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:partVar">Trouver l'entité partVar dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _partVar(Wrap<String> c);

	public String getPartVar() {
		return partVar;
	}

	public void setPartVar(String partVar) {
		this.partVar = partVar;
		this.partVarWrap.alreadyInitialized = true;
	}
	protected PagePart partVarInit() {
		if(!partVarWrap.alreadyInitialized) {
			_partVar(partVarWrap);
			if(partVar == null)
				setPartVar(partVarWrap.o);
		}
		partVarWrap.alreadyInitialized(true);
		return (PagePart)this;
	}

	public String solrPartVar() {
		return partVar;
	}

	public String strPartVar() {
		return partVar == null ? "" : partVar;
	}

	public String jsonPartVar() {
		return partVar == null ? "" : partVar;
	}

	public String nomAffichagePartVar() {
		return null;
	}

	public String htmTooltipPartVar() {
		return null;
	}

	public String htmPartVar() {
		return partVar == null ? "" : StringEscapeUtils.escapeHtml4(strPartVar());
	}

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedPagePart = false;

	public PagePart initDeepPagePart(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedPagePart) {
			alreadyInitializedPagePart = true;
			initDeepPagePart();
		}
		return (PagePart)this;
	}

	public void initDeepPagePart() {
		super.initDeepCluster(siteRequest_);
		initPagePart();
	}

	public void initPagePart() {
		page_Init();
		partVarInit();
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepPagePart(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestPagePart(SiteRequestEnUS siteRequest_) {
			super.siteRequestCluster(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestPagePart(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainPagePart(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainPagePart(String var) {
		PagePart oPagePart = (PagePart)this;
		switch(var) {
			case "page_":
				return oPagePart.page_;
			case "partVar":
				return oPagePart.partVar;
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
				o = attributePagePart(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributePagePart(String var, Object val) {
		PagePart oPagePart = (PagePart)this;
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
					o = definePagePart(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definePagePart(String var, String val) {
		switch(var) {
			default:
				return super.defineCluster(var, val);
		}
	}

	//////////////
	// htmlBody //
	//////////////

	public void htmlBody() {
		htmlBodyPagePart();
	}

	public void htmlBodyPagePart() {
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
		if(!(o instanceof PagePart))
			return false;
		PagePart that = (PagePart)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("PagePart { ");
		sb.append(" }");
		return sb.toString();
	}
}
