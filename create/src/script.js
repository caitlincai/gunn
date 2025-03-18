// List of quiz questions
const questions = [
    "How often does your skin feel oily throughout the day?",
    "Do you experience dry patches or flakiness?",
    "How shiny does your skin look by midday?",
    "Do you feel tightness in your skin after washing your face?",
    "How often do you experience acne or clogged pores?"
];

// Stores user answers (1-10 scale)
let answers = [];
let currentQuestion = 0;


function loadQuestion() {
    document.getElementById("question-text").textContent = questions[currentQuestion];

    // Create scale buttons (1-10)
    let scaleButtons = "";
    for (let i = 1; i <= 10; i++) {
        scaleButtons += `<button class="scale-btn" onclick="answer(${i})">${i}</button>`;
    }
    document.getElementById("scale-buttons").innerHTML = scaleButtons;
}

function answer(choice) {
    answers.push(choice); // Store answer
    currentQuestion++;

    if (currentQuestion < questions.length) {
        loadQuestion(); // Load next question
    } else {
        showResult(); // Show result after last question
    }
}

function startQuiz() {
    document.getElementById("start-btn").style.display = "none"; // Hide start button
    document.getElementById("quiz").style.display = "block"; // Show quiz
    loadQuestion(); // Start quiz
}

// Function to determine skin type
function determineSkinType(answers) {
    let totalScore = answers.reduce((a, b) => a + b, 0);

    if (totalScore >= 40) return "Oily Skin - Try gentler skin care products!";
    if (totalScore >= 25) return "Combination Skin - Remember to balance hydration!";
    if (totalScore >= 15) return "Normal Skin - Maintain your routine!";
    return "Dry Skin - Use deep moisturizers for dry skin!";
}

// Display result
function showResult() {
    let skinType = determineSkinType(answers);
    document.getElementById("quiz").style.display = "none";
    document.getElementById("result").textContent = "Your skin type: " + skinType;
}

// Start the quiz
loadQuestion();
