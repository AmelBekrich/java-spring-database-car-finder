document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("startingYear").value = 1900;
    document.getElementById("endingYear").value = 2026;

    window.changeConsumption = function() {
        var fuelType = document.getElementById("fuelType").value;
        var fuels = document.getElementById("fuels");
        var button = document.getElementById("button");

        button.style.display = "block";

        if (fuelType === "Gas") {
            document.getElementById("lowestConsumption").min = 4.6;
            document.getElementById("highestConsumption").max = 100;
            document.getElementById("lowestConsumption").value = 4.6;
            document.getElementById("highestConsumption").value = 100;
            fuels.style.display = "flex";
        } else if (fuelType === "Hybrid") {
            document.getElementById("lowestConsumption").min = 0.1;
            document.getElementById("highestConsumption").max = 4.5;
            document.getElementById("lowestConsumption").value = 0.1;
            document.getElementById("highestConsumption").value = 4.5;
            fuels.style.display = "flex";
        } else if (fuelType === "Electric" || fuelType === "All") {
            fuels.style.display = "none";
        }
    };
});