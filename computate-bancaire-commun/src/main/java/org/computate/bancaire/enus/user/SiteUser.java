package org.computate.bancaire.enus.user;

import org.computate.bancaire.enus.cluster.Cluster;
import org.computate.bancaire.enus.wrap.Wrap;

public class SiteUser extends SiteUserGen<Cluster> {

	protected void _userId(Wrap<String> c) {
		String o = siteRequest_.getUserId();
		c.o(o);
	}

	protected void _userName(Wrap<String> c) {
		String o = siteRequest_.getUserName();
		c.o(o);
	}

	protected void _userEmail(Wrap<String> c) {
	}

	protected void _userFirstName(Wrap<String> c) {
		String o = siteRequest_.getUserFirstName();
		c.o(o);
	}

	protected void _userLastName(Wrap<String> c) {
		String o = siteRequest_.getUserLastName();
		c.o(o);
	}

	protected void _userFullName(Wrap<String> c) {
		String o = siteRequest_.getUserFullName();
		c.o(o);
	}

	protected void _userSite(Wrap<String> c) {
	}

	protected void _userReceiveEmails(Wrap<Boolean> c) {
		c.o(false);
	}

	protected void _seeArchived(Wrap<Boolean> c) {
		c.o(false);
	}

	protected void _seeDeleted(Wrap<Boolean> c) {
		c.o(false);
	}

	public void  htmlBody() {
		super.htmlBody();
	}
}
