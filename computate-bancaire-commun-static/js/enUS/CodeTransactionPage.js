
// POST //

async function postTransactionCode($formValues, success, error) {
	var vals = {};
	if(success == null) {
		success = function( data, textStatus, jQxhr ) {
			addGlow($formValues.next('button'));
			var url = data['pageUrlPk'];
			if(url)
				window.location.href = url;
		};
	}
	if(error == null) {
		error = function( jqXhr, textStatus, errorThrown ) {
			addError($formValues.next('button'));
		};
	}

	var valuePk = $formValues.find('.valuePk').val();
	if(valuePk != null && valuePk !== '')
		vals['pk'] = valuePk;

	var valueCreated = $formValues.find('.valueCreated').val();
	if(valueCreated != null && valueCreated !== '')
		vals['created'] = valueCreated;

	var valueModified = $formValues.find('.valueModified').val();
	if(valueModified != null && valueModified !== '')
		vals['modified'] = valueModified;

	var valueObjectId = $formValues.find('.valueObjectId').val();
	if(valueObjectId != null && valueObjectId !== '')
		vals['objectId'] = valueObjectId;

	var valueTransactionCodeId = $formValues.find('.valueTransactionCodeId').val();
	if(valueTransactionCodeId != null && valueTransactionCodeId !== '')
		vals['transactionCodeId'] = valueTransactionCodeId;

	var valueArchived = $formValues.find('.valueArchived').prop('checked');
	if(valueArchived != null && valueArchived !== '')
		vals['archived'] = valueArchived;

	var valueDeleted = $formValues.find('.valueDeleted').prop('checked');
	if(valueDeleted != null && valueDeleted !== '')
		vals['deleted'] = valueDeleted;

	var valueTransactionCode = $formValues.find('.valueTransactionCode').val();
	if(valueTransactionCode != null && valueTransactionCode !== '')
		vals['transactionCode'] = valueTransactionCode;

	var valueTransactionCodeDisplayName = $formValues.find('.valueTransactionCodeDisplayName').val();
	if(valueTransactionCodeDisplayName != null && valueTransactionCodeDisplayName !== '')
		vals['transactionCodeDisplayName'] = valueTransactionCodeDisplayName;

	var valueTransactionCodeCompleteName = $formValues.find('.valueTransactionCodeCompleteName').val();
	if(valueTransactionCodeCompleteName != null && valueTransactionCodeCompleteName !== '')
		vals['transactionCodeCompleteName'] = valueTransactionCodeCompleteName;

	$.ajax({
		url: '/api/transaction-code'
		, dataType: 'json'
		, type: 'POST'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

function postTransactionCodeVals(vals, success, error) {
	$.ajax({
		url: '/api/transaction-code'
		, dataType: 'json'
		, type: 'POST'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// PATCH //

async function patchTransactionCode($formFilters, $formValues, success, error) {
	var filters = patchTransactionCodeFilters($formFilters);

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

	var removeTransactionCodeId = $formFilters.find('.removeTransactionCodeId').val() === 'true';
	var setTransactionCodeId = removeTransactionCodeId ? null : $formValues.find('.setTransactionCodeId').val();
	if(removeTransactionCodeId || setTransactionCodeId != null && setTransactionCodeId !== '')
		vals['setTransactionCodeId'] = setTransactionCodeId;
	var addTransactionCodeId = $formValues.find('.addTransactionCodeId').val();
	if(addTransactionCodeId != null && addTransactionCodeId !== '')
		vals['addTransactionCodeId'] = addTransactionCodeId;
	var removeTransactionCodeId = $formValues.find('.removeTransactionCodeId').val();
	if(removeTransactionCodeId != null && removeTransactionCodeId !== '')
		vals['removeTransactionCodeId'] = removeTransactionCodeId;

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

	var removeTransactionCode = $formFilters.find('.removeTransactionCode').val() === 'true';
	var setTransactionCode = removeTransactionCode ? null : $formValues.find('.setTransactionCode').val();
	if(removeTransactionCode || setTransactionCode != null && setTransactionCode !== '')
		vals['setTransactionCode'] = setTransactionCode;
	var addTransactionCode = $formValues.find('.addTransactionCode').val();
	if(addTransactionCode != null && addTransactionCode !== '')
		vals['addTransactionCode'] = addTransactionCode;
	var removeTransactionCode = $formValues.find('.removeTransactionCode').val();
	if(removeTransactionCode != null && removeTransactionCode !== '')
		vals['removeTransactionCode'] = removeTransactionCode;

	var removeTransactionCodeDisplayName = $formFilters.find('.removeTransactionCodeDisplayName').val() === 'true';
	var setTransactionCodeDisplayName = removeTransactionCodeDisplayName ? null : $formValues.find('.setTransactionCodeDisplayName').val();
	if(removeTransactionCodeDisplayName || setTransactionCodeDisplayName != null && setTransactionCodeDisplayName !== '')
		vals['setTransactionCodeDisplayName'] = setTransactionCodeDisplayName;
	var addTransactionCodeDisplayName = $formValues.find('.addTransactionCodeDisplayName').val();
	if(addTransactionCodeDisplayName != null && addTransactionCodeDisplayName !== '')
		vals['addTransactionCodeDisplayName'] = addTransactionCodeDisplayName;
	var removeTransactionCodeDisplayName = $formValues.find('.removeTransactionCodeDisplayName').val();
	if(removeTransactionCodeDisplayName != null && removeTransactionCodeDisplayName !== '')
		vals['removeTransactionCodeDisplayName'] = removeTransactionCodeDisplayName;

	var removeTransactionCodeCompleteName = $formFilters.find('.removeTransactionCodeCompleteName').val() === 'true';
	var setTransactionCodeCompleteName = removeTransactionCodeCompleteName ? null : $formValues.find('.setTransactionCodeCompleteName').val();
	if(removeTransactionCodeCompleteName || setTransactionCodeCompleteName != null && setTransactionCodeCompleteName !== '')
		vals['setTransactionCodeCompleteName'] = setTransactionCodeCompleteName;
	var addTransactionCodeCompleteName = $formValues.find('.addTransactionCodeCompleteName').val();
	if(addTransactionCodeCompleteName != null && addTransactionCodeCompleteName !== '')
		vals['addTransactionCodeCompleteName'] = addTransactionCodeCompleteName;
	var removeTransactionCodeCompleteName = $formValues.find('.removeTransactionCodeCompleteName').val();
	if(removeTransactionCodeCompleteName != null && removeTransactionCodeCompleteName !== '')
		vals['removeTransactionCodeCompleteName'] = removeTransactionCodeCompleteName;

	patchTransactionCodeVals(filters, vals, success, error);
}

function patchTransactionCodeFilters($formFilters) {
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

	var filterTransactionCodeId = $formFilters.find('.valueTransactionCodeId').val();
	if(filterTransactionCodeId != null && filterTransactionCodeId !== '')
		filters.push({ name: 'fq', value: 'transactionCodeId:' + filterTransactionCodeId });

	var filterArchived = $formFilters.find('.valueArchived').prop('checked');
	if(filterArchived != null && filterArchived === true)
		filters.push({ name: 'fq', value: 'archived:' + filterArchived });

	var filterDeleted = $formFilters.find('.valueDeleted').prop('checked');
	if(filterDeleted != null && filterDeleted === true)
		filters.push({ name: 'fq', value: 'deleted:' + filterDeleted });

	var filterTransactionCode = $formFilters.find('.valueTransactionCode').val();
	if(filterTransactionCode != null && filterTransactionCode !== '')
		filters.push({ name: 'fq', value: 'transactionCode:' + filterTransactionCode });

	var filterTransactionCodeDisplayName = $formFilters.find('.valueTransactionCodeDisplayName').val();
	if(filterTransactionCodeDisplayName != null && filterTransactionCodeDisplayName !== '')
		filters.push({ name: 'fq', value: 'transactionCodeDisplayName:' + filterTransactionCodeDisplayName });

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

	var filterSessionId = $formFilters.find('.valueSessionId').val();
	if(filterSessionId != null && filterSessionId !== '')
		filters.push({ name: 'fq', value: 'sessionId:' + filterSessionId });

	var filterObjectTitle = $formFilters.find('.valueObjectTitle').val();
	if(filterObjectTitle != null && filterObjectTitle !== '')
		filters.push({ name: 'fq', value: 'objectTitle:' + filterObjectTitle });

	var filterObjectSuggest = $formFilters.find('.valueObjectSuggest').val();
	if(filterObjectSuggest != null && filterObjectSuggest !== '')
		filters.push({ name: 'q', value: 'objectSuggest:' + filterObjectSuggest });

	var filterPageUrlId = $formFilters.find('.valuePageUrlId').val();
	if(filterPageUrlId != null && filterPageUrlId !== '')
		filters.push({ name: 'fq', value: 'pageUrlId:' + filterPageUrlId });

	var filterPageUrlPk = $formFilters.find('.valuePageUrlPk').val();
	if(filterPageUrlPk != null && filterPageUrlPk !== '')
		filters.push({ name: 'fq', value: 'pageUrlPk:' + filterPageUrlPk });

	var filterTransactionCodeKey = $formFilters.find('.valueTransactionCodeKey').val();
	if(filterTransactionCodeKey != null && filterTransactionCodeKey !== '')
		filters.push({ name: 'fq', value: 'transactionCodeKey:' + filterTransactionCodeKey });

	var filterTransactionCodeCompleteName = $formFilters.find('.valueTransactionCodeCompleteName').val();
	if(filterTransactionCodeCompleteName != null && filterTransactionCodeCompleteName !== '')
		filters.push({ name: 'fq', value: 'transactionCodeCompleteName:' + filterTransactionCodeCompleteName });

	var filterPageUrl = $formFilters.find('.valuePageUrl').val();
	if(filterPageUrl != null && filterPageUrl !== '')
		filters.push({ name: 'fq', value: 'pageUrl:' + filterPageUrl });

	var filterObjectSuggest = $formFilters.find('.valueObjectSuggest').val();
	if(filterObjectSuggest != null && filterObjectSuggest !== '')
		filters.push({ name: 'q', value: 'objectSuggest:' + filterObjectSuggest });
	return filters;
}

function patchTransactionCodeVal(filters, v, val, success, error) {
	var vals = {};
	vals[v] = val;
	patchTransactionCodeVals(filters, vals, success, error);
}

function patchTransactionCodeVals(filters, vals, success, error) {
	$.ajax({
		url: '/api/transaction-code?' + $.param(filters)
		, dataType: 'json'
		, type: 'PATCH'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// GET //

async function getTransactionCode(pk) {
	$.ajax({
		url: '/api/transaction-code/' + id
		, dataType: 'json'
		, type: 'GET'
		, contentType: 'application/json; charset=utf-8'
		, success: success
		, error: error
	});
}

// DELETE //

async function deleteTransactionCode(pk) {
	$.ajax({
		url: '/api/transaction-code/' + id
		, dataType: 'json'
		, type: 'DELETE'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// Search //

async function searchTransactionCode($formFilters, success, error) {
	var filters = searchTransactionCodeFilters($formFilters);
	if(success == null)
		success = function( data, textStatus, jQxhr ) {};
	if(error == null)
		error = function( jqXhr, textStatus, errorThrown ) {};

	searchTransactionCodeVals(filters, success, error);
}

function searchTransactionCodeFilters($formFilters) {
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

	var filterTransactionCodeId = $formFilters.find('.valueTransactionCodeId').val();
	if(filterTransactionCodeId != null && filterTransactionCodeId !== '')
		filters.push({ name: 'fq', value: 'transactionCodeId:' + filterTransactionCodeId });

	var filterArchived = $formFilters.find('.valueArchived').prop('checked');
	if(filterArchived != null && filterArchived === true)
		filters.push({ name: 'fq', value: 'archived:' + filterArchived });

	var filterDeleted = $formFilters.find('.valueDeleted').prop('checked');
	if(filterDeleted != null && filterDeleted === true)
		filters.push({ name: 'fq', value: 'deleted:' + filterDeleted });

	var filterTransactionCode = $formFilters.find('.valueTransactionCode').val();
	if(filterTransactionCode != null && filterTransactionCode !== '')
		filters.push({ name: 'fq', value: 'transactionCode:' + filterTransactionCode });

	var filterTransactionCodeDisplayName = $formFilters.find('.valueTransactionCodeDisplayName').val();
	if(filterTransactionCodeDisplayName != null && filterTransactionCodeDisplayName !== '')
		filters.push({ name: 'fq', value: 'transactionCodeDisplayName:' + filterTransactionCodeDisplayName });

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

	var filterSessionId = $formFilters.find('.valueSessionId').val();
	if(filterSessionId != null && filterSessionId !== '')
		filters.push({ name: 'fq', value: 'sessionId:' + filterSessionId });

	var filterObjectTitle = $formFilters.find('.valueObjectTitle').val();
	if(filterObjectTitle != null && filterObjectTitle !== '')
		filters.push({ name: 'fq', value: 'objectTitle:' + filterObjectTitle });

	var filterObjectSuggest = $formFilters.find('.valueObjectSuggest').val();
	if(filterObjectSuggest != null && filterObjectSuggest !== '')
		filters.push({ name: 'q', value: 'objectSuggest:' + filterObjectSuggest });

	var filterPageUrlId = $formFilters.find('.valuePageUrlId').val();
	if(filterPageUrlId != null && filterPageUrlId !== '')
		filters.push({ name: 'fq', value: 'pageUrlId:' + filterPageUrlId });

	var filterPageUrlPk = $formFilters.find('.valuePageUrlPk').val();
	if(filterPageUrlPk != null && filterPageUrlPk !== '')
		filters.push({ name: 'fq', value: 'pageUrlPk:' + filterPageUrlPk });

	var filterTransactionCodeKey = $formFilters.find('.valueTransactionCodeKey').val();
	if(filterTransactionCodeKey != null && filterTransactionCodeKey !== '')
		filters.push({ name: 'fq', value: 'transactionCodeKey:' + filterTransactionCodeKey });

	var filterTransactionCodeCompleteName = $formFilters.find('.valueTransactionCodeCompleteName').val();
	if(filterTransactionCodeCompleteName != null && filterTransactionCodeCompleteName !== '')
		filters.push({ name: 'fq', value: 'transactionCodeCompleteName:' + filterTransactionCodeCompleteName });

	var filterPageUrl = $formFilters.find('.valuePageUrl').val();
	if(filterPageUrl != null && filterPageUrl !== '')
		filters.push({ name: 'fq', value: 'pageUrl:' + filterPageUrl });

	var filterObjectSuggest = $formFilters.find('.valueObjectSuggest').val();
	if(filterObjectSuggest != null && filterObjectSuggest !== '')
		filters.push({ name: 'q', value: 'objectSuggest:' + filterObjectSuggest });
	return filters;
}

function searchTransactionCodeVals(filters, success, error) {
	$.ajax({
		url: '/api/transaction-code?' + $.param(filters)
		, dataType: 'json'
		, type: 'GET'
		, contentType: 'application/json; charset=utf-8'
		, success: success
		, error: error
	});
}

function suggestTransactionCodeObjectSuggest($formFilters, $list) {
	success = function( data, textStatus, jQxhr ) {
		$list.empty();
		$.each(data['list'], function(i, o) {
			var $i = $('<i>').attr('class', 'fad fa-code-commit w3-padding-small ');
			var $span = $('<span>').attr('class', '').text(o['transactionCodeCompleteName']);
			var $li = $('<li>');
			var $a = $('<a>').attr('href', o['pageUrlPk']);
			$a.append($i);
			$a.append($span);
			$li.append($a);
			$list.append($li);
		});
	};
	error = function( jqXhr, textStatus, errorThrown ) {};
	searchTransactionCodeVals($formFilters, success, error);
}

function suggestTransactionCodeObjectSuggest($formFilters, $list) {
	success = function( data, textStatus, jQxhr ) {
		$list.empty();
		$.each(data['list'], function(i, o) {
			var $i = $('<i>').attr('class', 'fad fa-code-commit w3-padding-small ');
			var $span = $('<span>').attr('class', '').text(o['transactionCodeCompleteName']);
			var $li = $('<li>');
			var $a = $('<a>').attr('href', o['pageUrlPk']);
			$a.append($i);
			$a.append($span);
			$li.append($a);
			$list.append($li);
		});
	};
	error = function( jqXhr, textStatus, errorThrown ) {};
	searchTransactionCodeVals($formFilters, success, error);
}

async function websocketTransactionCode(success) {
	window.eventBus.onopen = function () {

		window.eventBus.registerHandler('websocketTransactionCode', function (error, message) {
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
				var $header = $('<div>').attr('class', 'w3-container fa-yellow ').attr('id', 'header-' + id);
				var $i = $('<i>').attr('class', 'fad fa-code-commit w3-margin-right ').attr('id', 'icon-' + id);
				var $headerSpan = $('<span>').attr('class', '').text('modify bank transaction codes');
				var $x = $('<span>').attr('class', 'w3-button w3-display-topright ').attr('onclick', '$("#card-' + id + '").hide(); ').attr('id', 'x-' + id);
				var $body = $('<div>').attr('class', 'w3-container w3-padding ').attr('id', 'text-' + id);
				var $bar = $('<div>').attr('class', 'w3-light-gray ').attr('id', 'bar-' + id);
				var $progress = $('<div>').attr('class', 'w3-yellow ').attr('style', 'height: 24px; width: ' + percent + '; ').attr('id', 'progress-' + id).text(numPATCH + '/' + numFound);
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
async function websocketTransactionCodeInner(patchRequest) {
	var pk = patchRequest['pk'];
	var pks = patchRequest['pks'];
	var classes = patchRequest['classes'];
	var vars = patchRequest['vars'];
	var empty = patchRequest['empty'];

	if(pk != null) {
		searchTransactionCodeVals([ {name: 'fq', value: 'pk:' + pk} ], function( data, textStatus, jQxhr ) {
			var o = data['list'][0];
			if(vars.includes('created')) {
				$('.inputTransactionCode' + pk + 'Created').val(o['created']);
				$('.varTransactionCode' + pk + 'Created').text(o['created']);
			}
			if(vars.includes('modified')) {
				$('.inputTransactionCode' + pk + 'Modified').val(o['modified']);
				$('.varTransactionCode' + pk + 'Modified').text(o['modified']);
			}
			if(vars.includes('archived')) {
				$('.inputTransactionCode' + pk + 'Archived').val(o['archived']);
				$('.varTransactionCode' + pk + 'Archived').text(o['archived']);
			}
			if(vars.includes('deleted')) {
				$('.inputTransactionCode' + pk + 'Deleted').val(o['deleted']);
				$('.varTransactionCode' + pk + 'Deleted').text(o['deleted']);
			}
			if(vars.includes('transactionCode')) {
				$('.inputTransactionCode' + pk + 'TransactionCode').val(o['transactionCode']);
				$('.varTransactionCode' + pk + 'TransactionCode').text(o['transactionCode']);
			}
			if(vars.includes('transactionCodeDisplayName')) {
				$('.inputTransactionCode' + pk + 'TransactionCodeDisplayName').val(o['transactionCodeDisplayName']);
				$('.varTransactionCode' + pk + 'TransactionCodeDisplayName').text(o['transactionCodeDisplayName']);
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
		await patchTransactionCodeVals( [ {name: 'fq', value: 'pk:' + pk} ], {});
	}
}
