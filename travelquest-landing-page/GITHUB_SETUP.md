# GitHub Repository Setup Guide

This guide walks you through creating and setting up the `travelquest-landing-page` GitHub repository.

## 📚 Step 1: Create GitHub Repository

### Option A: Using GitHub Web Interface

1. **Go to GitHub**: Visit [github.com](https://github.com) and sign in to your account.

2. **Create New Repository**:
   - Click the "+" icon in the top right corner
   - Select "New repository"
   - Repository name: `travelquest-landing-page`
   - Description: `Modern, responsive landing page for TravelQuest - a gamified travel experience mobile app`
   - Set to **Public** (recommended for GitHub Pages)
   - ✅ Initialize with README (we'll replace it)
   - ✅ Add .gitignore: **Node**
   - ✅ Choose license: **MIT License**

3. **Create Repository**: Click "Create repository"

### Option B: Using GitHub CLI (if you have it installed)

```bash
gh repo create travelquest-landing-page --public --description "Modern, responsive landing page for TravelQuest - a gamified travel experience mobile app" --add-readme --gitignore Node --license MIT
```

## 📁 Step 2: Connect Local Project to GitHub

From your `travelquest-landing-page` directory:

```bash
# Initialize git (if not already done)
git init

# Add GitHub repository as remote origin
git remote add origin https://github.com/YOUR_USERNAME/travelquest-landing-page.git

# Add all files to git
git add .

# Create initial commit
git commit -m "Initial commit: TravelQuest landing page with React, TypeScript, Tailwind CSS, and Framer Motion"

# Push to GitHub
git push -u origin main
```

⚠️ **Important**: Replace `YOUR_USERNAME` with your actual GitHub username.

## 🔧 Step 3: Configure Repository Settings

### Enable GitHub Pages

1. **Go to Repository Settings**:
   - Navigate to your repository on GitHub
   - Click on "Settings" tab
   - Scroll down to "Pages" section

2. **Configure GitHub Pages**:
   - Source: "Deploy from a branch"
   - Branch: `gh-pages` (will be created when you first deploy)
   - Folder: `/ (root)`

3. **Save Settings**: Click "Save"

### Update Repository Description and Topics

1. **Edit Repository Details**:
   - Go to your repository main page
   - Click the ⚙️ gear icon next to "About"
   - Update description: `Modern, responsive landing page for TravelQuest - a gamified travel experience mobile app`
   - Website: Add your deployment URL when available
   - Topics: Add relevant tags like:
     - `react`
     - `typescript`
     - `tailwindcss`
     - `framer-motion`
     - `landing-page`
     - `travel-app`
     - `responsive-design`
     - `mobile-first`

## 🚀 Step 4: Deploy to GitHub Pages

```bash
# Build and deploy to GitHub Pages
npm run deploy
```

This command will:
1. Build the project (`npm run build`)
2. Create a `gh-pages` branch
3. Push the build files to the `gh-pages` branch
4. Your site will be available at: `https://YOUR_USERNAME.github.io/travelquest-landing-page`

## 📋 Step 5: Update Package.json Homepage

Update the homepage URL in `package.json` with your actual GitHub username:

```json
{
  "homepage": "https://YOUR_USERNAME.github.io/travelquest-landing-page"
}
```

Then commit and push the change:

```bash
git add package.json
git commit -m "Update homepage URL with actual GitHub username"
git push
```

## 🔐 Step 6: Security and Best Practices

### Enable Branch Protection (Optional)

1. **Go to Settings > Branches**
2. **Add rule for `main` branch**:
   - ✅ Require a pull request before merging
   - ✅ Require status checks to pass before merging
   - ✅ Require branches to be up to date before merging

### Add Repository Secrets (For CI/CD)

If you plan to add automated deployments:

1. **Go to Settings > Secrets and variables > Actions**
2. **Add secrets** like:
   - `VERCEL_TOKEN` (for Vercel deployment)
   - `NETLIFY_AUTH_TOKEN` (for Netlify deployment)

## 📊 Step 7: Set Up Project Management

### Add Issue Templates

Create `.github/ISSUE_TEMPLATE/` directory with templates:

1. **Bug Report Template**
2. **Feature Request Template**
3. **Documentation Update Template**

### Add Pull Request Template

Create `.github/pull_request_template.md`:

```markdown
## Description
Brief description of changes

## Type of Change
- [ ] Bug fix
- [ ] New feature
- [ ] Documentation update
- [ ] Performance improvement
- [ ] Code refactoring

## Testing
- [ ] Tested locally
- [ ] Build passes
- [ ] Responsive design verified
- [ ] Accessibility checked

## Screenshots (if applicable)
<!-- Add screenshots here -->

## Checklist
- [ ] Code follows project style guidelines
- [ ] Self-review of the code completed
- [ ] Changes generate no new warnings
- [ ] Documentation updated (if needed)
```

## 🌟 Step 8: Add Badges to README

Add status badges to your README.md:

```markdown
# TravelQuest Landing Page

[![Deploy to GitHub Pages](https://github.com/YOUR_USERNAME/travelquest-landing-page/actions/workflows/deploy.yml/badge.svg)](https://github.com/YOUR_USERNAME/travelquest-landing-page/actions/workflows/deploy.yml)
[![Live Demo](https://img.shields.io/badge/Live-Demo-brightgreen)](https://YOUR_USERNAME.github.io/travelquest-landing-page)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![React](https://img.shields.io/badge/React-18+-blue.svg)](https://reactjs.org/)
[![TypeScript](https://img.shields.io/badge/TypeScript-Latest-blue.svg)](https://www.typescriptlang.org/)
[![Tailwind CSS](https://img.shields.io/badge/Tailwind%20CSS-3+-blue.svg)](https://tailwindcss.com/)
```

## 🔄 Step 9: Set Up Automatic Deployments (Optional)

### GitHub Actions for Automated Deployment

Create `.github/workflows/deploy.yml`:

```yaml
name: Deploy to GitHub Pages

on:
  push:
    branches: [ main ]
  pull_request:
    branches: [ main ]

jobs:
  build-and-deploy:
    runs-on: ubuntu-latest
    
    steps:
    - name: Checkout
      uses: actions/checkout@v3
      
    - name: Setup Node.js
      uses: actions/setup-node@v3
      with:
        node-version: '18'
        cache: 'npm'
        
    - name: Install dependencies
      run: npm ci
      
    - name: Build
      run: npm run build
      
    - name: Deploy to GitHub Pages
      if: github.ref == 'refs/heads/main'
      run: |
        git config --global user.name 'github-actions[bot]'
        git config --global user.email 'github-actions[bot]@users.noreply.github.com'
        npm run deploy
      env:
        GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
```

## 📝 Step 10: Final Checklist

Before going live:

- [ ] Repository is created and configured
- [ ] Code is pushed to GitHub
- [ ] GitHub Pages is enabled
- [ ] Deployment is successful
- [ ] Live URL is working
- [ ] README is updated with correct URLs
- [ ] Repository description and topics are set
- [ ] All placeholder content is reviewed
- [ ] Social media links are updated (or placeholder noted)
- [ ] Contact information is correct

## 🎉 Step 11: Share Your Work

Once everything is set up:

1. **Update your portfolio** with the project link
2. **Share on social media** (Twitter, LinkedIn, etc.)
3. **Submit to showcases** like:
   - Awwwards
   - CSS Design Awards
   - Site Inspire
   - Product Hunt (if applicable)

## 🆘 Troubleshooting

### Common Issues:

1. **403 Error on GitHub Pages**:
   - Check if repository is public
   - Verify GitHub Pages source settings
   - Ensure `gh-pages` branch exists

2. **Build Fails on Deployment**:
   - Check Node.js version compatibility
   - Verify all dependencies are in package.json
   - Check for environment-specific issues

3. **Styling Issues**:
   - Verify Tailwind CSS is properly configured
   - Check PostCSS settings
   - Ensure all CSS imports are correct

### Getting Help:

- GitHub Issues: Create an issue in your repository
- GitHub Discussions: For broader questions
- Stack Overflow: Tag with `github-pages`, `react`, `tailwindcss`

---

## 🚀 You're All Set!

Your TravelQuest landing page is now live on GitHub Pages! 

**Next Steps:**
1. Customize the content for your specific needs
2. Add real testimonials and app store links
3. Consider setting up analytics
4. Plan for SEO optimization
5. Prepare for mobile app launch integration

**Happy coding! 🎉**