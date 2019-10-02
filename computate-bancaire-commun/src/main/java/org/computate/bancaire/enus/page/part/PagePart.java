package org.computate.bancaire.enus.page.part;

import org.computate.bancaire.enus.cluster.Cluster;
import org.computate.bancaire.enus.wrap.Wrap;
import org.computate.bancaire.enus.page.PageLayout;

public abstract class PagePart extends PagePartGen<Cluster> {

	protected void _page_(Wrap<PageLayout> c) {}

	public void  htmlBody() {
		
	}

	public void  htmlBodyShort() {
		
	}

	protected void _partVar(Wrap<String> c) {}

	public void  htmlBeforePagePart() {}

	public void  htmlAfterPagePart() {}
}
