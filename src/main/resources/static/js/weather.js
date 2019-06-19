var WeatherService = function() {
	/**
	 * Load city list to drop-down
	 */
	var loadCityList = function() {
		var select_city = $('#select_city');
		
		var get = $.get("/retrieveCityList.json");		
		get.done(function(response) {
			if (response) {
				$.each(response, function(key, value) {
					select_city.append('<option value=' + value.id + '>' + value.name.trim() + '</option>');
				});
			}
		});		
	}
	
	/**
	 * Handle UI actions
	 */
	var bindUIActions = function() {
		// handle event of city drop-down changed
		$('#select_city').on('change', function() {
			loadWeather();
		});
	}
	
	/**
	 * Retrieve weather info from server
	 */
	var loadWeather = function() {
		var selectedCity = $('#select_city').val();
		if(!selectedCity) {
			fillWeatherData([]);
			return;
		}
		var param = {
				id : selectedCity,
		};
		
		var post = $.post("/retrieveCityWeather.json", param);
		post.done(function(response) {
			fillWeatherData(response);
		})
		.fail(function(response) {
			var json = $.parseJSON(response.responseText);
			$('#warningModal .modal-body').text(json.message);
			$('#warningModal').modal('show');
		});
	}
	
	var fillWeatherData = function(response) {
		var currentDate = moment().format('dddd h:mm A'); 
		
		$('#sp_city').text(response.city || '');
		$('#sp_updated_time').text(currentDate);
		$('#sp_weather').text(response.weather || '');
		$('#sp_temperature').html((response.temperature) ?  response.temperature + "&#8451;" : '');
		$('#sp_wind').text(response.wind || '');
	}
	
    return {
        init: function() {
            loadCityList();
            bindUIActions();
        }
    };
}();
$(function() {
	WeatherService.init();
});