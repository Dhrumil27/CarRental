$(document).ready(function() {
});

function refreshRentedData() {
	$('#cars').empty();
	$.ajax({
		url: "http://localhost:8080/api/getRentedList"
	}).then(function(data) {
		console.log('data', data);
		for (i = 0; i < data.length; i++) {
			$('#cars').append(
					"<ul class='rented-cars'><li>" + data[i].name + " " +
					"(Price: " + data[i].price.toFixed(2) + " " + ") " +
					"<button onClick='postReturn(" + data[i].id + ")'>Return</button>" +
			"</li></ul>");
		}

	});
}

function refreshFreeData() {
	$('#cars').empty();
	$.ajax({
		url: "http://localhost:8080/api/getFreeList"
	}).then(function(data) {
		console.log('data', data);
		for (i = 0; i < data.length; i++) {
			$('#cars').append(
					"<ul class='free-cars'><li>" + data[i].name + " " +
					"(Price: " + data[i].price.toFixed(2) + " " +") " +
					"<button onClick='postRent(" + data[i].id + ")'>Rent</button>" +
					"</li></ul>"
			);
		}
	});
}

function postRent(id) {
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/api/rentCar/" + id,
		dataType: "json",
		success: function (result, status, xhr) {
			refreshFreeData();
		},
		error: function (xhr, status, error) {
			alert(xhr.responseJSON.message);
		}
	});
}

function postReturn(id) {
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/api/returnCar/" + id,
		dataType: "json",
		success: function (result, status, xhr) {
			refreshRentedData();
		},
		error: function (xhr, status, error) {
			alert(xhr.responseJSON.message);
		}
	});
}
