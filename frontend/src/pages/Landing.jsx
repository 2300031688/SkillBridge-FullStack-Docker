import { Link } from "react-router-dom";

export default function Landing() {
  return (
    <>
      <nav className="navbar">
        <Link to="/" className="logo">
          Skill<span>Bridge</span>.
        </Link>

        <div className="nav-links">
          <a href="#features">Features</a>
          <a href="#how">How It Works</a>
        </div>

        <div className="nav-actions">
          <Link to="/login" className="nav-login">
            Login
          </Link>
          <Link to="/register" className="nav-cta">
            Get Started
          </Link>
        </div>
      </nav>

      <section className="hero">
        <div>
          <span className="hero-badge">AI-POWERED CAREER DEVELOPMENT</span>
          <h1>Find Your Skill Gap. Bridge It Together.</h1>
          <p>
            Discover what skills you need for your target career and choose
            between personalized learning or peer-to-peer skill exchange.
          </p>
          <Link to="/register" className="primary-btn">
            Start Your Journey →
          </Link>
        </div>

        <div className="hero-card">
          <div className="readiness">
            <div className="score">
              <strong>72%</strong>
              <small>Ready</small>
            </div>
            <div>
              <span className="section-label">CAREER READINESS</span>
              <h2>Java Full Stack Developer</h2>
              <p>Strong foundation. A few skills to bridge.</p>
            </div>
          </div>

          <div className="skill-pills">
            <span>Java ✓</span>
            <span>Spring Boot ✓</span>
            <span>React ✓</span>
            <span>Docker ⚠</span>
            <span>AWS !</span>
          </div>
        </div>
      </section>

      <section id="features" className="features">
        <span className="section-label">WHY SKILLBRIDGE</span>
        <h2>Everything you need to grow</h2>

        <div className="features-grid">
          {[
            ["🎯", "Skill Gap Analysis", "Understand exactly what you need to learn."],
            ["📚", "Personal Roadmap", "Get a roadmap based on your target role."],
            ["🤝", "Peer Learning", "Learn directly from students with the skills you need."],
            ["📈", "Track Progress", "Measure improvement and reassess your readiness."]
          ].map(([icon, title, text]) => (
            <div className="feature-card" key={title}>
              <div className="feature-icon">{icon}</div>
              <h3>{title}</h3>
              <p>{text}</p>
            </div>
          ))}
        </div>
      </section>

      <section id="how" className="how-section">
        <span className="section-label">HOW IT WORKS</span>
        <h2>Bridge your skill gap in four steps</h2>

        <div className="how-grid">
          {[
            ["01", "Tell us your goal", "Choose your target career role and share your current skills."],
            ["02", "Discover your gap", "SkillBridge compares your skills with role requirements."],
            ["03", "Choose your path", "Learn yourself or connect with a peer."],
            ["04", "Improve & reassess", "Track progress and measure your improvement."]
          ].map(([number, title, text]) => (
            <div className="how-card" key={number}>
              <strong>{number}</strong>
              <h3>{title}</h3>
              <p>{text}</p>
            </div>
          ))}
        </div>
      </section>

      <footer className="footer">
        <strong>SkillBridge.</strong>
        <p>AI-powered career development and peer skill exchange.</p>
      </footer>
    </>
  );
}