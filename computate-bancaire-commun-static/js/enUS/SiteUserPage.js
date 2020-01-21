
// PATCH //

async function patchSiteUser($formFilters, $formValues, success, error) {
	var filters = patchSiteUserFilters($formFilters);

	var vals = {};

	var removePk = $formFilters.find('.removePk').val() === 'true';
	var setPk = removePk ? null : $formValues.find('.setPk').val();
	if(removePk || setPk != null && setPk !== '')
		vals['setPk'] = setPk;
	var addPk = $formValues.find('.addPk').val();
	if(addPk != null && addPk !== '')
		vals['addPk'] = addPk;
	var removePk = $formValues.find('.removePk').val();
	if(removePk != null && removePk !== '')
		vals['removePk'] = removePk;

	var removeCreated = $formFilters.find('.removeCreated').val() === 'true';
	var setCreated = removeCreated ? null : $formValues.find('.setCreated').val();
	if(removeCreated || setCreated != null && setCreated !== '')
		vals['setCreated'] = setCreated;
	var addCreated = $formValues.find('.addCreated').val();
	if(addCreated != null && addCreated !== '')
		vals['addCreated'] = addCreated;
	var removeCreated = $formValues.find('.removeCreated').val();
	if(removeCreated != null && removeCreated !== '')
		vals['removeCreated'] = removeCreated;

	var removeModified = $formFilters.find('.removeModified').val() === 'true';
	var setModified = removeModified ? null : $formValues.find('.setModified').val();
	if(removeModified || setModified != null && setModified !== '')
		vals['setModified'] = setModified;
	var addModified = $formValues.find('.addModified').val();
	if(addModified != null && addModified !== '')
		vals['addModified'] = addModified;
	var removeModified = $formValues.find('.removeModified').val();
	if(removeModified != null && removeModified !== '')
		vals['removeModified'] = removeModified;

	var removeObjectId = $formFilters.find('.removeObjectId').val() === 'true';
	var setObjectId = removeObjectId ? null : $formValues.find('.setObjectId').val();
	if(removeObjectId || setObjectId != null && setObjectId !== '')
		vals['setObjectId'] = setObjectId;
	var addObjectId = $formValues.find('.addObjectId').val();
	if(addObjectId != null && addObjectId !== '')
		vals['addObjectId'] = addObjectId;
	var removeObjectId = $formValues.find('.removeObjectId').val();
	if(removeObjectId != null && removeObjectId !== '')
		vals['removeObjectId'] = removeObjectId;

	var removeArchived = $formFilters.find('.removeArchived').val() === 'true';
	var setArchived = removeArchived ? null : $formValues.find('.setArchived').prop('checked');
	if(removeArchived || setArchived != null && setArchived !== '')
		vals['setArchived'] = setArchived;
	var addArchived = $formValues.find('.addArchived').prop('checked');
	if(addArchived != null && addArchived !== '')
		vals['addArchived'] = addArchived;
	var removeArchived = $formValues.find('.removeArchived').prop('checked');
	if(removeArchived != null && removeArchived !== '')
		vals['removeArchived'] = removeArchived;

	var removeDeleted = $formFilters.find('.removeDeleted').val() === 'true';
	var setDeleted = removeDeleted ? null : $formValues.find('.setDeleted').prop('checked');
	if(removeDeleted || setDeleted != null && setDeleted !== '')
		vals['setDeleted'] = setDeleted;
	var addDeleted = $formValues.find('.addDeleted').prop('checked');
	if(addDeleted != null && addDeleted !== '')
		vals['addDeleted'] = addDeleted;
	var removeDeleted = $formValues.find('.removeDeleted').prop('checked');
	if(removeDeleted != null && removeDeleted !== '')
		vals['removeDeleted'] = removeDeleted;

	var removeUserReceiveEmails = $formFilters.find('.removeUserReceiveEmails').val() === 'true';
	var setUserReceiveEmails = removeUserReceiveEmails ? null : $formValues.find('.setUserReceiveEmails').prop('checked');
	if(removeUserReceiveEmails || setUserReceiveEmails != null && setUserReceiveEmails !== '')
		vals['setUserReceiveEmails'] = setUserReceiveEmails;
	var addUserReceiveEmails = $formValues.find('.addUserReceiveEmails').prop('checked');
	if(addUserReceiveEmails != null && addUserReceiveEmails !== '')
		vals['addUserReceiveEmails'] = addUserReceiveEmails;
	var removeUserReceiveEmails = $formValues.find('.removeUserReceiveEmails').prop('checked');
	if(removeUserReceiveEmails != null && removeUserReceiveEmails !== '')
		vals['removeUserReceiveEmails'] = removeUserReceiveEmails;

	var removeSeeArchived = $formFilters.find('.removeSeeArchived').val() === 'true';
	var setSeeArchived = removeSeeArchived ? null : $formValues.find('.setSeeArchived').prop('checked');
	if(removeSeeArchived || setSeeArchived != null && setSeeArchived !== '')
		vals['setSeeArchived'] = setSeeArchived;
	var addSeeArchived = $formValues.find('.addSeeArchived').prop('checked');
	if(addSeeArchived != null && addSeeArchived !== '')
		vals['addSeeArchived'] = addSeeArchived;
	var removeSeeArchived = $formValues.find('.removeSeeArchived').prop('checked');
	if(removeSeeArchived != null && removeSeeArchived !== '')
		vals['removeSeeArchived'] = removeSeeArchived;

	var removeSeeDeleted = $formFilters.find('.removeSeeDeleted').val() === 'true';
	var setSeeDeleted = removeSeeDeleted ? null : $formValues.find('.setSeeDeleted').prop('checked');
	if(removeSeeDeleted || setSeeDeleted != null && setSeeDeleted !== '')
		vals['setSeeDeleted'] = setSeeDeleted;
	var addSeeDeleted = $formValues.find('.addSeeDeleted').prop('checked');
	if(addSeeDeleted != null && addSeeDeleted !== '')
		vals['addSeeDeleted'] = addSeeDeleted;
	var removeSeeDeleted = $formValues.find('.removeSeeDeleted').prop('checked');
	if(removeSeeDeleted != null && removeSeeDeleted !== '')
		vals['removeSeeDeleted'] = removeSeeDeleted;

	patchSiteUserVals(filters, vals, success, error);
}

function patchSiteUserFilters($formFilters) {
	var filters = [];

	var filterPk = $formFilters.find('.valuePk').val();
	if(filterPk != null && filterPk !== '')
		filters.push({ name: 'fq', value: 'pk:' + filterPk });

	var filterCreated = $formFilters.find('.valueCreated').val();
	if(filterCreated != null && filterCreated !== '')
		filters.push({ name: 'fq', value: 'created:' + filterCreated });

	var filterModified = $formFilters.find('.valueModified').val();
	if(filterModified != null && filterModified !== '')
		filters.push({ name: 'fq', value: 'modified:' + filterModified });

	var filterObjectId = $formFilters.find('.valueObjectId').val();
	if(filterObjectId != null && filterObjectId !== '')
		filters.push({ name: 'fq', value: 'objectId:' + filterObjectId });

	var filterArchived = $formFilters.find('.valueArchived').prop('checked');
	if(filterArchived != null && filterArchived === true)
		filters.push({ name: 'fq', value: 'archived:' + filterArchived });

	var filterDeleted = $formFilters.find('.valueDeleted').prop('checked');
	if(filterDeleted != null && filterDeleted === true)
		filters.push({ name: 'fq', value: 'deleted:' + filterDeleted });

	var filterUserReceiveEmails = $formFilters.find('.valueUserReceiveEmails').prop('checked');
	if(filterUserReceiveEmails != null && filterUserReceiveEmails === true)
		filters.push({ name: 'fq', value: 'userReceiveEmails:' + filterUserReceiveEmails });

	var filterSeeArchived = $formFilters.find('.valueSeeArchived').prop('checked');
	if(filterSeeArchived != null && filterSeeArchived === true)
		filters.push({ name: 'fq', value: 'seeArchived:' + filterSeeArchived });

	var filterSeeDeleted = $formFilters.find('.valueSeeDeleted').prop('checked');
	if(filterSeeDeleted != null && filterSeeDeleted === true)
		filters.push({ name: 'fq', value: 'seeDeleted:' + filterSeeDeleted });

	var filterId = $formFilters.find('.valueId').val();
	if(filterId != null && filterId !== '')
		filters.push({ name: 'fq', value: 'id:' + filterId });

	var filterClassCanonicalName = $formFilters.find('.valueClassCanonicalName').val();
	if(filterClassCanonicalName != null && filterClassCanonicalName !== '')
		filters.push({ name: 'fq', value: 'classCanonicalName:' + filterClassCanonicalName });

	var filterClassSimpleName = $formFilters.find('.valueClassSimpleName').val();
	if(filterClassSimpleName != null && filterClassSimpleName !== '')
		filters.push({ name: 'fq', value: 'classSimpleName:' + filterClassSimpleName });

	var filterClassCanonicalNames = $formFilters.find('.valueClassCanonicalNames').val();
	if(filterClassCanonicalNames != null && filterClassCanonicalNames !== '')
		filters.push({ name: 'fq', value: 'classCanonicalNames:' + filterClassCanonicalNames });

	var filterObjectTitle = $formFilters.find('.valueObjectTitle').val();
	if(filterObjectTitle != null && filterObjectTitle !== '')
		filters.push({ name: 'fq', value: 'objectTitle:' + filterObjectTitle });

	var filterObjectSuggest = $formFilters.find('.valueObjectSuggest').val();
	if(filterObjectSuggest != null && filterObjectSuggest !== '')
		filters.push({ name: 'q', value: 'objectSuggest:' + filterObjectSuggest });

	var filterPageUrl = $formFilters.find('.valuePageUrl').val();
	if(filterPageUrl != null && filterPageUrl !== '')
		filters.push({ name: 'fq', value: 'pageUrl:' + filterPageUrl });

	var filterUserName = $formFilters.find('.valueUserName').val();
	if(filterUserName != null && filterUserName !== '')
		filters.push({ name: 'fq', value: 'userName:' + filterUserName });

	var filterUserEmail = $formFilters.find('.valueUserEmail').val();
	if(filterUserEmail != null && filterUserEmail !== '')
		filters.push({ name: 'fq', value: 'userEmail:' + filterUserEmail });

	var filterUserFirstName = $formFilters.find('.valueUserFirstName').val();
	if(filterUserFirstName != null && filterUserFirstName !== '')
		filters.push({ name: 'fq', value: 'userFirstName:' + filterUserFirstName });

	var filterUserLastName = $formFilters.find('.valueUserLastName').val();
	if(filterUserLastName != null && filterUserLastName !== '')
		filters.push({ name: 'fq', value: 'userLastName:' + filterUserLastName });

	var filterUserFullName = $formFilters.find('.valueUserFullName').val();
	if(filterUserFullName != null && filterUserFullName !== '')
		filters.push({ name: 'fq', value: 'userFullName:' + filterUserFullName });

	var filterUserSite = $formFilters.find('.valueUserSite').val();
	if(filterUserSite != null && filterUserSite !== '')
		filters.push({ name: 'fq', value: 'userSite:' + filterUserSite });
	return filters;
}

function patchSiteUserVal(filters, v, val, success, error) {
	var vals = {};
	vals[v] = val;
	patchSiteUserVals(filters, vals, success, error);
}

function patchSiteUserVals(filters, vals, success, error) {
	$.ajax({
		url: '/api/user?' + $.param(filters)
		, dataType: 'json'
		, type: 'PATCH'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

async function websocketSiteUser(success) {
	window.eventBus.onopen = function () {

		window.eventBus.registerHandler('websocketSiteUser', function (error, message) {
			var json = JSON.parse(message['body']);
			var id = json['id'];
			var pk = json['pk'];
			var pks = json['pks'];
			var empty = json['empty'];
			if(!empty) {
				var numFound = json['numFound'];
				var numPATCH = json['numPATCH'];
				var percent = Math.floor( numPATCH / numFound * 100 ) + '%';
				var $box = $('<div>').attr('class', 'w3-display-topright w3-quarter box-' + id + ' ').attr('id', 'box-' + id);
				var $margin = $('<div>').attr('class', 'w3-margin ').attr('id', 'margin-' + id);
				var $card = $('<div>').attr('class', 'w3-card ').attr('id', 'card-' + id);
				var $header = $('<div>').attr('class', 'w3-container fa-gray ').attr('id', 'header-' + id);
				var $i = $('<i>').attr('class', 'far fa-user-cog w3-margin-right ').attr('id', 'icon-' + id);
				var $headerSpan = $('<span>').attr('class', '').text('modify site users');
				var $x = $('<span>').attr('class', 'w3-button w3-display-topright ').attr('onclick', '$("#card-' + id + '").hide(); ').attr('id', 'x-' + id);
				var $body = $('<div>').attr('class', 'w3-container w3-padding ').attr('id', 'text-' + id);
				var $bar = $('<div>').attr('class', 'w3-light-gray ').attr('id', 'bar-' + id);
				var $progress = $('<div>').attr('class', 'w3-gray ').attr('style', 'height: 24px; width: ' + percent + '; ').attr('id', 'progress-' + id).text(numPATCH + '/' + numFound);
				$card.append($header);
				$header.append($i);
				$header.append($headerSpan);
				$header.append($x);
				$body.append($bar);
				$bar.append($progress);
				$card.append($body);
				$box.append($margin);
				$margin.append($card);
				$('.box-' + id).remove();
				if(numPATCH < numFound)
				$('.w3-content').append($box);
				if(success)
					success(json);
			}
		});
	}
}
async function websocketSiteUserInner(patchRequest) {
	var pk = patchRequest['pk'];
	var pks = patchRequest['pks'];
	var classes = patchRequest['classes'];
	var vars = patchRequest['vars'];
	var empty = patchRequest['empty'];

	if(pk != null) {
		searchSiteUserVals([ {name: 'fq', value: 'pk:' + pk} ], function( data, textStatus, jQxhr ) {
			var o = data['list'][0];
			if(vars.includes('created')) {
				$('.inputSiteUser' + pk + 'Created').val(o['created']);
				$('.varSiteUser' + pk + 'Created').text(o['created']);
			}
			if(vars.includes('modified')) {
				$('.inputSiteUser' + pk + 'Modified').val(o['modified']);
				$('.varSiteUser' + pk + 'Modified').text(o['modified']);
			}
			if(vars.includes('archived')) {
				$('.inputSiteUser' + pk + 'Archived').val(o['archived']);
				$('.varSiteUser' + pk + 'Archived').text(o['archived']);
			}
			if(vars.includes('deleted')) {
				$('.inputSiteUser' + pk + 'Deleted').val(o['deleted']);
				$('.varSiteUser' + pk + 'Deleted').text(o['deleted']);
			}
			if(vars.includes('userReceiveEmails')) {
				$('.inputSiteUser' + pk + 'UserReceiveEmails').val(o['userReceiveEmails']);
				$('.varSiteUser' + pk + 'UserReceiveEmails').text(o['userReceiveEmails']);
			}
			if(vars.includes('seeArchived')) {
				$('.inputSiteUser' + pk + 'SeeArchived').val(o['seeArchived']);
				$('.varSiteUser' + pk + 'SeeArchived').text(o['seeArchived']);
			}
			if(vars.includes('seeDeleted')) {
				$('.inputSiteUser' + pk + 'SeeDeleted').val(o['seeDeleted']);
				$('.varSiteUser' + pk + 'SeeDeleted').text(o['seeDeleted']);
			}
		});
	}

	if(!empty) {
		if(pks) {
			for(i=0; i < pks.length; i++) {
				var pk2 = pks[i];
				var c = classes[i];
				await window['patch' + c + 'Vals']( [ {name: 'fq', value: 'pk:' + pk2} ], {});
			}
		}
		await patchSiteUserVals( [ {name: 'fq', value: 'pk:' + pk} ], {});
	}
}
