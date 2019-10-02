
// POST //

function postTransactionCode($formValues) {
	var vals = {};

	var valuePk = $formValues.find('.valuePk').val();
	if(valuePk != null && valuePk !== '')
		vals['pk'] = valuePk;

	var valueCreated = $formValues.find('.valueCreated').val();
	if(valueCreated != null && valueCreated !== '')
		vals['created'] = valueCreated;

	var valueModified = $formValues.find('.valueModified').val();
	if(valueModified != null && valueModified !== '')
		vals['modified'] = valueModified;

	var valueTransactionCodeId = $formValues.find('.valueTransactionCodeId').val();
	if(valueTransactionCodeId != null && valueTransactionCodeId !== '')
		vals['transactionCodeId'] = valueTransactionCodeId;

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

function patchTransactionCode($formFilters, $formValues, success, error) {
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

	var filterTransactionCodeId = $formFilters.find('.valueTransactionCodeId').val();
	if(filterTransactionCodeId != null && filterTransactionCodeId !== '')
		filters.push({ name: 'fq', value: 'transactionCodeId:' + filterTransactionCodeId });

	var filterTransactionCode = $formFilters.find('.valueTransactionCode').val();
	if(filterTransactionCode != null && filterTransactionCode !== '')
		filters.push({ name: 'fq', value: 'transactionCode:' + filterTransactionCode });

	var filterTransactionCodeDisplayName = $formFilters.find('.valueTransactionCodeDisplayName').val();
	if(filterTransactionCodeDisplayName != null && filterTransactionCodeDisplayName !== '')
		filters.push({ name: 'fq', value: 'transactionCodeDisplayName:' + filterTransactionCodeDisplayName });

	var filterId = $formFilters.find('.valueId').val();
	if(filterId != null && filterId !== '')
		filters.push({ name: 'fq', value: 'id:' + filterId });

	var filterArchived = $formFilters.find('.valueArchived').prop('checked');
	if(filterArchived != null && filterArchived === true)
		filters.push({ name: 'fq', value: 'archived:' + filterArchived });

	var filterDeleted = $formFilters.find('.valueDeleted').prop('checked');
	if(filterDeleted != null && filterDeleted === true)
		filters.push({ name: 'fq', value: 'deleted:' + filterDeleted });

	var filterClassCanonicalName = $formFilters.find('.valueClassCanonicalName').val();
	if(filterClassCanonicalName != null && filterClassCanonicalName !== '')
		filters.push({ name: 'fq', value: 'classCanonicalName:' + filterClassCanonicalName });

	var filterClassSimpleName = $formFilters.find('.valueClassSimpleName').val();
	if(filterClassSimpleName != null && filterClassSimpleName !== '')
		filters.push({ name: 'fq', value: 'classSimpleName:' + filterClassSimpleName });

	var filterClassCanonicalNames = $formFilters.find('.valueClassCanonicalNames').val();
	if(filterClassCanonicalNames != null && filterClassCanonicalNames !== '')
		filters.push({ name: 'fq', value: 'classCanonicalNames:' + filterClassCanonicalNames });

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

function getTransactionCode(pk) {
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

function deleteTransactionCode(pk) {
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

function searchTransactionCode($formFilters, success, error) {
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

	var filterTransactionCodeId = $formFilters.find('.valueTransactionCodeId').val();
	if(filterTransactionCodeId != null && filterTransactionCodeId !== '')
		filters.push({ name: 'fq', value: 'transactionCodeId:' + filterTransactionCodeId });

	var filterTransactionCode = $formFilters.find('.valueTransactionCode').val();
	if(filterTransactionCode != null && filterTransactionCode !== '')
		filters.push({ name: 'fq', value: 'transactionCode:' + filterTransactionCode });

	var filterTransactionCodeDisplayName = $formFilters.find('.valueTransactionCodeDisplayName').val();
	if(filterTransactionCodeDisplayName != null && filterTransactionCodeDisplayName !== '')
		filters.push({ name: 'fq', value: 'transactionCodeDisplayName:' + filterTransactionCodeDisplayName });

	var filterId = $formFilters.find('.valueId').val();
	if(filterId != null && filterId !== '')
		filters.push({ name: 'fq', value: 'id:' + filterId });

	var filterArchived = $formFilters.find('.valueArchived').prop('checked');
	if(filterArchived != null && filterArchived === true)
		filters.push({ name: 'fq', value: 'archived:' + filterArchived });

	var filterDeleted = $formFilters.find('.valueDeleted').prop('checked');
	if(filterDeleted != null && filterDeleted === true)
		filters.push({ name: 'fq', value: 'deleted:' + filterDeleted });

	var filterClassCanonicalName = $formFilters.find('.valueClassCanonicalName').val();
	if(filterClassCanonicalName != null && filterClassCanonicalName !== '')
		filters.push({ name: 'fq', value: 'classCanonicalName:' + filterClassCanonicalName });

	var filterClassSimpleName = $formFilters.find('.valueClassSimpleName').val();
	if(filterClassSimpleName != null && filterClassSimpleName !== '')
		filters.push({ name: 'fq', value: 'classSimpleName:' + filterClassSimpleName });

	var filterClassCanonicalNames = $formFilters.find('.valueClassCanonicalNames').val();
	if(filterClassCanonicalNames != null && filterClassCanonicalNames !== '')
		filters.push({ name: 'fq', value: 'classCanonicalNames:' + filterClassCanonicalNames });

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
			var $a = $('<a>').attr('href', o['pageUrl']);
			$a.append($i);
			$a.append($span);
			$li.append($a);
			$list.append($li);
		});
	};
	error = function( jqXhr, textStatus, errorThrown ) {};
	searchTransactionCodeVals($formFilters, success, error);
}
