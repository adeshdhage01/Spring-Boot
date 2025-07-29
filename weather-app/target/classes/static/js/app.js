document.addEventListener('DOMContentLoaded', function() {
    const weatherForm = document.getElementById('weatherForm');
    const cityInput = document.getElementById('city');
    
    // Focus on the input field when the page loads
    cityInput.focus();
    
    weatherForm.addEventListener('submit', function(e) {
        const city = cityInput.value.trim();
        if (!city) {
            e.preventDefault();
            alert('Please enter a city name');
        }
    });
    
    // Check for error parameter in URL
    const urlParams = new URLSearchParams(window.location.search);
    if (urlParams.has('error')) {
        cityInput.focus();
    }
});