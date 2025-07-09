# TravelQuest Landing Page

A modern, responsive landing page for TravelQuest - a gamified travel experience mobile app.

## 🚀 Features

- **Modern Design**: Clean, professional design with smooth animations
- **Responsive**: Mobile-first design that works on all devices
- **Animations**: Smooth animations powered by Framer Motion
- **Tailwind CSS**: Utility-first CSS framework for rapid development
- **TypeScript**: Type-safe development experience
- **Performance**: Optimized for fast loading and great user experience

## 📱 Sections

1. **Hero Section**: Eye-catching introduction with app store badges
2. **Features**: Key app features with icons and descriptions
3. **Mobile Mockup**: Visual demonstration of the app interface
4. **Testimonials**: User reviews and testimonials
5. **Call-to-Action**: Download buttons and final conversion section
6. **Footer**: Links and company information

## 🛠️ Technology Stack

- **React** 18+ with TypeScript
- **Tailwind CSS** for styling
- **Framer Motion** for animations
- **Create React App** for development setup

## 🏃‍♂️ Getting Started

### Prerequisites

- Node.js 16+ 
- npm or yarn

### Installation

1. Clone the repository:
```bash
git clone https://github.com/your-username/travelquest-landing-page.git
cd travelquest-landing-page
```

2. Install dependencies:
```bash
npm install
```

3. Start the development server:
```bash
npm start
```

4. Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

## 📦 Build & Deployment

### Build for Production

```bash
npm run build
```

### Deploy to Vercel

1. Install Vercel CLI:
```bash
npm i -g vercel
```

2. Deploy:
```bash
vercel
```

### Deploy to GitHub Pages

1. Install gh-pages:
```bash
npm install --save-dev gh-pages
```

2. Add homepage to package.json:
```json
"homepage": "https://your-username.github.io/travelquest-landing-page"
```

3. Add deploy scripts to package.json:
```json
"scripts": {
  "predeploy": "npm run build",
  "deploy": "gh-pages -d build"
}
```

4. Deploy:
```bash
npm run deploy
```

## 🎨 Customization

### Colors

The color scheme can be customized in `tailwind.config.js`:

- Primary colors (blue tones)
- Secondary colors (orange tones)

### Content

Update the content in `src/App.tsx`:

- Hero section messaging
- Feature descriptions
- Testimonials
- Company information

### Styling

Custom styles are defined in:
- `src/index.css` - Global styles and Tailwind customizations
- `tailwind.config.js` - Tailwind configuration

## 📱 Mobile App Store Assets

The landing page includes download buttons for:
- iOS App Store (with Apple logo)
- Google Play Store (with Google Play logo)

Update the button links when the actual app is published.

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🔗 Links

- [Live Demo](https://your-deployment-url.com) (Update with actual URL)
- [Design System](https://tailwindcss.com/docs)
- [Framer Motion Docs](https://www.framer.com/motion/)

## 📞 Support

For support, email support@travelquest.com or join our Discord community.

---

**TravelQuest** - Gamify Your Journey 🌟
