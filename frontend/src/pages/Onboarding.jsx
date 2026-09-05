import { useState } from "react";
import { useNavigate } from "react-router-dom";

export default function Onboarding() {
  const navigate = useNavigate();
  const [inputType, setInputType] = useState("");
  const [resume, setResume] = useState(null);

  const [formData, setFormData] = useState({
    targetRole: "",
    experience: "",
    skills: ""
  });

  const handleChange = (event) => {
    setFormData({
      ...formData,
      [event.target.name]: event.target.value
    });
  };

  const handleContinue = () => {
    if (!formData.targetRole || !formData.experience || !inputType) {
      alert("Please complete all required fields.");
      return;
    }

    if (inputType === "manual" && !formData.skills.trim()) {
      alert("Please enter your skills.");
      return;
    }

    if (inputType === "resume" && !resume) {
      alert("Please upload your resume.");
      return;
    }

    localStorage.setItem("targetRole", formData.targetRole);
    localStorage.setItem(
      "currentSkills",
      inputType === "manual" ? formData.skills : ""
    );

    navigate("/skill-analysis", {
      state: {
        ...formData,
        inputType,
        resumeName: resume?.name || ""
      }
    });
  };

  return (
    <div className="onboarding-page">
      <div className="onboarding-container">
        <div className="onboarding-header">
          <span className="section-label">STEP 1 OF 2</span>
          <h1>Let's understand your career goal</h1>
          <p>Tell us where you are today and where you want to go.</p>
        </div>

        <div className="form-section">
          <label htmlFor="targetRole">What role are you targeting?</label>

          <select
            id="targetRole"
            name="targetRole"
            value={formData.targetRole}
            onChange={handleChange}
          >
            <option value="">Select your target role</option>
            <option>Java Full Stack Developer</option>
            <option>Frontend Developer</option>
            <option>Backend Developer</option>
            <option>Python Developer</option>
            <option>Data Analyst</option>
            <option>Cloud Engineer</option>
            <option>DevOps Engineer</option>
          </select>
        </div>

        <div className="form-section">
          <label>What is your experience level?</label>

          <div className="experience-options">
            {[
              ["FRESHER", "🎓", "Fresher", "Student or starting my career"],
              ["EXPERIENCED", "💼", "Experienced", "I already have professional experience"]
            ].map(([value, icon, title, description]) => (
              <button
                key={value}
                type="button"
                className={`experience-card ${
                  formData.experience === value ? "selected" : ""
                }`}
                onClick={() =>
                  setFormData({
                    ...formData,
                    experience: value
                  })
                }
              >
                <span>{icon}</span>
                <strong>{title}</strong>
                <small>{description}</small>
              </button>
            ))}
          </div>
        </div>

        <div className="form-section">
          <label>How would you like to provide your skills?</label>

          <div className="input-options">
            <button
              type="button"
              className={`input-card ${
                inputType === "resume" ? "selected" : ""
              }`}
              onClick={() => setInputType("resume")}
            >
              <strong>📄 Upload Resume</strong>
              <p>We'll extract your skills automatically.</p>
            </button>

            <button
              type="button"
              className={`input-card ${
                inputType === "manual" ? "selected" : ""
              }`}
              onClick={() => setInputType("manual")}
            >
              <strong>✍️ Enter Skills Manually</strong>
              <p>Tell us what skills you currently have.</p>
            </button>
          </div>
        </div>

        {inputType === "resume" && (
          <div className="resume-upload">
            <h3>Upload your resume</h3>
            <p>PDF files only · Maximum 5MB</p>
            <input
              type="file"
              accept=".pdf"
              onChange={(event) => setResume(event.target.files[0] || null)}
            />
            {resume && <p>Selected: {resume.name}</p>}
          </div>
        )}

        {inputType === "manual" && (
          <div className="manual-skills">
            <label htmlFor="skills">Your current skills</label>
            <textarea
              id="skills"
              name="skills"
              value={formData.skills}
              onChange={handleChange}
              placeholder="Example: Java, Spring Boot, React, SQL, Git, HTML, CSS"
              rows="4"
            />
            <small>Separate multiple skills using commas.</small>
          </div>
        )}

        <button
          className="continue-button"
          type="button"
          onClick={handleContinue}
        >
          Continue →
        </button>
      </div>
    </div>
  );
}