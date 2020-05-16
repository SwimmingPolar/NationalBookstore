function flexibleSlidify(sliderWindow) {
  // const sliderWindow = target.querySelector('.flexible-slider-window');
  const slider = sliderWindow.querySelector('.flexible-slider');
  const slides = [...(slider.querySelectorAll('.flexible-slide'))];

  // set current states
  let isGrabbing = false;
  let isMoved = false;

  // set current slider window width
  const sliderWindowWidth = slider.clientWidth || Number(window.getComputedStyle(slider).width.replace('px', ''));
  // set current slider's max width (sum of current slides width);
  // width, padding, margin taken into account
  const sliderWidth = slides.reduce((totalWidth, slide) => {
    const margin = Number(window.getComputedStyle(slide).marginLeft.replace('px', '')) +
                  Number(window.getComputedStyle(slide).marginRight.replace('px', ''));
    const width = slide.clientWidth || Number(window.getComputedStyle(slide).width.replace('px', ''));
    return totalWidth += margin + width;
  }, 0);
  // mouse travel time: mouse button released time - mouse button pressed time
  let mouseUpTimestamp = 0;
  let mouseDownTimestamp = 0;
  let mouseTravelTime = 0;
  // offset between last event's clientX and current event's clientX (works for same event only)
  let movementX = 0;
  // sliding duration
  // default: 800ms
  // when sliding back to start(0px) and/or end(sliderWidth - sliderWindowWidth)px: 300ms
  let slidingDuration = 800;
  
  // final sliding offset
  let slidingOffset = 0;

  const getCurrentX = () => Number(window.getComputedStyle(slider).transform.split(',')[4]);
  // prevent clicking on 'a' and/or 'button' tag after moving slider
  document.addEventListener('click', event => {
    if (!isMoved) return;
    // event.stopPropagation();
    // event.preventDefault();
  });
  document.addEventListener('mousedown', event => {
    // enable sliding only if event target is descendant of slider
    if (!(slider.contains(event.target))) return;
    isGrabbing = true;
    isMoved = false;
  });
  document.addEventListener('mousemove', event => {
    if (!isGrabbing) return;
    isMoved = true;
    movementX = event.movementX;
    mouseDownTimestamp = event.timeStamp;

    // if mouse move does not occur right above the slider
    // limit slider move to 70% of mouse move
    let currentX = getCurrentX() || 0;
    currentX = (function(futureX) {
      if (futureX > 0)
        return currentX + Math.floor(event.movementX*0.375);
      else if (futureX < -1*(sliderWidth - sliderWindowWidth))
        return currentX + Math.floor(event.movementX*0.375);
      else
        return currentX + event.movementX;
    }(currentX + event.movementX));

    // remove transition effect
    slider.style.transition = '';

    // move slider to current position
    slider.style.transform = 'translateX(' + currentX + 'px)';
  });
  document.addEventListener('mouseup', event => {
    isGrabbing = false;
    mouseUpTimestamp = event.timeStamp;
    // time < 1 : add sliding effect when swing mouse to accelerate
    // time < 150 : add soft sliding effect when moderately slided
    // else : remove sliding effect when slide and hold more than 150ms
    mouseTravelTime = (function(time) {
      if (time < 1)
        return 1 - time;
      else if (time < 150)
        return 1;
      else
        return 0;
    }(Math.abs(mouseUpTimestamp - mouseDownTimestamp)));

    // slidingOffset : total distance to be added to current slider position after valid mouse release
    // 0.05: sliding coefficient to be multiply to sliding offset (0.01: stiff ~ 0.05: smooth recommended)
    slidingOffset = mouseTravelTime * movementX * 0.05 * sliderWindowWidth;

    // add transition properties
    slider.style.transitionDuration = slidingDuration + 'ms';
    slider.style.transitionTimingFunction = 'cubic-bezier(0.33, 1, 0.68, 1)';

    let currentX = getCurrentX() || 0;
    currentX = (function(currentX) {
      if (currentX > 0) {
        slider.style.transitionDuration = '400ms';
        return 0;
      }
      else if (currentX < -1*(sliderWidth - sliderWindowWidth)) {
        slider.style.transitionDuration = '400ms';
        return (sliderWidth - sliderWindowWidth)*-1;
      }
      else
        return currentX;
    }(currentX + slidingOffset));

    // add transition
    slider.style.transform = 'translateX(' + currentX + 'px)'
  });
}
// infinite slider must be loaded prior to "window.onload"
function infiniteSlidify(sliderWindow) {
  const slider = sliderWindow.querySelector('.infinite-slider');
  const sliderIndicators = [...(sliderWindow.querySelectorAll('.slider-indicator li'))];
  // HTML Live List needed for duplicated slides insertion (getElementsByClassName)
  const slides = slider.getElementsByClassName('infinite-slide');

  // duplicate slides for infinite sliding
  // 4 slides each to start and end for cushion
  // filter to remove undefined element and map to clone element node
  const getSlides = (startIndex, lastIndex) => [...slides].filter((slide, index) => startIndex <= index && index < lastIndex).map(slide => slide.cloneNode(true));
  const appendSlides = (pos, slides) => slides.forEach(slide => slider.insertAdjacentElement(pos, slide).classList.add('duplicated-infinite-slide'));

  const clonedSlides = {
    // last slides should be reversed for FILO style insertion
    'afterbegin': getSlides(slides.length - 4, slides.length).reverse(),
    'beforeend': getSlides(0, 4)
  };
  Object.keys(clonedSlides).forEach(key => appendSlides(key, clonedSlides[key]));

  // returns element width;
  // const getWidth = element => element.clientWidth || Number(window.getComputedStyle(element).width.replace('px', ''));
  const getWidth = element => {
    const margin = (Number(window.getComputedStyle(element).marginLeft.replace('px', '')) || 0) +
                  (Number(window.getComputedStyle(element).marginRight.replace('px', '')) || 0);
    const width = element.clientWidth || Number(window.getComputedStyle(element).width.replace('px', ''));
    return margin + width;
  };
  const slideWidth = getWidth(slides[0]);

  // remove transition style before adjusting position
  slider.style.transition = '';
  // adjust slider position to prior state after cloning
  slider.style.transform = 'translateX(' + -1 * getWidth(slides[0]) * clonedSlides['afterbegin'].length + 'px)';
  
  let isGrabbing = false;
  let isMoved = false;

  const sliderWindowWidth = getWidth(sliderWindow);
  const sliderWidth = [...slides].reduce((totalWidth, slide) => totalWidth + getWidth(slide), 0);

  let mouseUpTimestamp = 0;
  let mouseDownTimestamp = 0;
  let mouseTravelTime = 0;

  let movementX = 0;

  let slidingDuration = 400;

  let slidingOffset = 0;

  // total duplicated slides length
  const duplicatedSlidesLength = [...(sliderWindow.querySelectorAll('.duplicated-infinite-slide'))].length;
  // get current slider's position
  const getCurrentX = () => Number(window.getComputedStyle(slider).transform.split(',')[4]);
  // get closest slide starting position
  const getClosest = futureX => Math.round(futureX / slideWidth) * slideWidth;
  const getValidSliderPosition = function(evaluatingX) {
    const index = (-1 * evaluatingX) / slideWidth;
    if (index < duplicatedSlidesLength/2)
      return slides.length - duplicatedSlidesLength/2 - (duplicatedSlidesLength/2 - index);
    if (index >= slides.length - duplicatedSlidesLength/2)
      return duplicatedSlidesLength - (slides.length - index);
    return index;
  };
  // re-style indicator
  const adjustIndicator = function(index) {
    if(!sliderIndicators.length) return;
    sliderIndicators.forEach(indicator => {
      if (indicator.classList.contains('active'))
        indicator.classList.remove('active');
    });
    sliderIndicators[index].classList.add('active');
  }

  // lock slider while transition occurs
  let transitionLock = false;
  // lock slider when mouse is hovered
  let mouseOverLock = false;

  // add indicator events
  if (sliderIndicators) {
    sliderIndicators.forEach((indicator, index) => {
      indicator.addEventListener('click', () => {
        if (transitionLock) return;

        adjustIndicator(index);

        slider.style.transitionDuration = slidingDuration + 'ms';
        slider.style.transitionTimingFunction = 'cubic-bezier(0.33, 1, 0.68, 1)';
        slider.style.transform = 'translateX(' + (-1 * (index + duplicatedSlidesLength/2) * slideWidth)  + 'px)'
      });
    });
  }

  // add click event to prev, next if any
  const buttons = {
    'prev': sliderWindow.querySelector('.prev'),
    'next': sliderWindow.querySelector('.next')
  };
  Object.keys(buttons).forEach(direction => {
    if (!buttons[direction]) return;
    buttons[direction].addEventListener('click', event => {
      if (transitionLock) return;

      const step = direction === 'prev' ? 1 : -1;
      const currentX = getCurrentX() + (slideWidth * step);
      slider.style.transitionDuration = slidingDuration + 'ms';
      slider.style.transitionTimingFunction = 'cubic-bezier(0.33, 1, 0.68, 1)';
      slider.style.transform = 'translateX(' + getClosest(currentX) + 'px)'

      const indicatorIndex = getValidSliderPosition(currentX) - duplicatedSlidesLength/2;
      adjustIndicator(indicatorIndex);
    });
  });

  let intervalID = undefined;
  let isViewportVisible = document.hasFocus() && document.visibilityState;

  // stop slider when the current page lost focus or otherwise switch to other tab or program
  document.addEventListener('visibilitychange', () => document.hidden ? isViewportVisible = false : isViewportVisible = true);
  window.addEventListener('blur', () => isViewportVisible = false);
  window.addEventListener('focus', () => isViewportVisible = true);
  // auto sliding function
  function autoSliding() {
    // clear scheduled callback and re-initiate
    intervalID = clearInterval(intervalID) || setInterval(() => {
      // if any of below lock is not cleared then do not slide (transisionLock)
      // viewport must be visible to user to be slided automatically (isViewportVisible, isPartiallyVisible)
      if (transitionLock || mouseOverLock || !isViewportVisible || !isPartiallyVisible(sliderWindow)) return;
      buttons['next'].click();
    }, 3500);
  }

  // lock slider when mouse is hovered on sliderWindow
  sliderWindow.addEventListener('mouseover', () => mouseOverLock = true);
  sliderWindow.addEventListener('mouseout', () => mouseOverLock = false);
  
  // lock slider when traisition starts
  slider.addEventListener('transitionstart', () => transitionLock = true);
  slider.addEventListener('transitionend', () => {
    // unlock slider after transition ends
    transitionLock = false;

    // reset auto sliding timer after manual sliding
    autoSliding();

    const currentIndex = Math.floor(-1 * getCurrentX() / slideWidth);
    const moveTo = getValidSliderPosition(getCurrentX());

    if (currentIndex === moveTo) return;
              
    // instantly reposition slider
    slider.style.transitionDuration = '';
    slider.style.transitionTimingFunction = '';
    slider.style.transform = 'translateX(' + -1 * moveTo * slideWidth + 'px)'
  });

  document.addEventListener('click', event => {
    if (!isMoved) return;
    event.stopPropagation();
    event.preventDefault();
  });
  document.addEventListener('mousedown', event => {
    if (!(slider.contains(event.target))) return;
    isGrabbing = true;
    isMoved = false;
  });
  document.addEventListener('mousemove', event => {
    if (!isGrabbing) return;
    transitionLock = true;
    isMoved = true;
    movementX = event.movementX;
    mouseDownTimestamp = event.timeStamp;

    let currentX = getCurrentX() || 0;
    currentX = (function(futureX) {
      if (futureX > 0)
        return currentX + Math.floor(event.movementX*0.1);
      else if (futureX < -1*(sliderWidth - slideWidth))
        return currentX + Math.floor(event.movementX*0.1);
      else
        return currentX + Math.floor(event.movementX*0.75);
    }(currentX + event.movementX));

    slider.style.transition = '';

    slider.style.transform = 'translateX(' + currentX + 'px)';
  });
  document.addEventListener('mouseup', event => {
    if (!isGrabbing) return;
    isGrabbing = false;
    mouseUpTimestamp = event.timeStamp;

    mouseTravelTime = (function(time) {
      if (time < 1)
        return 1 - time;
      else
        return 0;
    }(Math.abs(mouseUpTimestamp - mouseDownTimestamp)));

    slidingOffset = mouseTravelTime * movementX * 0.01 * slideWidth;

    slider.style.transitionDuration = slidingDuration + 'ms';
    slider.style.transitionTimingFunction = 'cubic-bezier(0.33, 1, 0.68, 1)';

    let currentX = getCurrentX() || 0;
    currentX = (function(currentX) {
      if (currentX > 0)
        return 0;
      else if (currentX < -1*(sliderWidth - slideWidth))
        return (sliderWidth - slideWidth)*-1;
      else
        return currentX;
    }(currentX + slidingOffset));

    slider.style.transform = 'translateX(' + getClosest(currentX) + 'px)'

    const indicatorIndex = getValidSliderPosition(getClosest(currentX)) - duplicatedSlidesLength/2;
    adjustIndicator(indicatorIndex);
  });
  // start auto sliding
  autoSliding();
}
// returns true if given element is fully visible on the viewport
function isFullyVisible(element) {
  const {top, bottom, left, right} = element.getBoundingClientRect();
  return (top >= 0 && bottom >= 0 ) && (left >= 0 && right >= 0);
}
// returns true if any portion of given element is visible on the viewport
function isPartiallyVisible(element) {
  const {top, bottom, left, right} = element.getBoundingClientRect();
  return (top <= window.innerHeight && bottom >= 0) &&
         (left <= window.innerWidth && right >= 0);
}
// returns true if 'threshhold' percentage of given element's height is visible on the viewport
function isVerticallyVisible(element, threshhold = 0.25) {
  const {top, bottom, height} = element.getBoundingClientRect();
  return (top + (height * threshhold) <= window.innerHeight && top > 0) ||
         (bottom >= (height * threshhold) && top < 0);
}
// remove 'targets' from 'original' array
function removeElementsFrom(original, targets) {
  return original.filter(originalElement => !(targets.includes(originalElement)));
}
function revealElements(hiddenElements) {
  let revealed = hiddenElements.filter(element => isVerticallyVisible(element));
  // add elements placed before current scroll position
  const priorElements = hiddenElements.filter(element => element.getBoundingClientRect().top <= 0);
  revealed = [...revealed, ...priorElements];
  // sort targeted fadeInUp elements in vertical order
  revealed = revealed.sort((prev, next) => prev.getBoundingClientRect().top - next.getBoundingClientRect().top);

  revealed.forEach(element => element.classList.add('revealed'));
  // remove 'fadeInUp', 'revealed' class after animation ends
  revealed.forEach(element => element.addEventListener('animationend', () => element.classList.remove('fadeInUp', 'revealed')));
  // returns un-revealed elements
  return removeElementsFrom(hiddenElements, revealed);
}
// add 'fadeInUp reveal effect' on elements with '.fadeInUp' class
function addFadeInUpEffects() {
  // reveal elements on document.ready and return leftover hidden elements
  let targetElements = [...(document.querySelectorAll('.fadeInUp'))];
  // initiate first round of revealing
  targetElements = revealElements(targetElements);

  window.addEventListener('scroll', function fadeInUp() {
    targetElements = revealElements(targetElements);
    // if there are no elements to be revealed then detach fadeInUp scroll event
    if (targetElements.length === 0)
      window.removeEventListener('scroll', fadeInUp);
  });
}
if (window.onload) alert('common.js load warning: window.onload event already exists');
window.onload = function() {
  // slidify targeted elements
  // slider structure: 
  // window: .flexible-slider-window
  // slider: .flexible-slider
  // slide: .flexible-slide
  const flexibleSliderWindows = [...(document.querySelectorAll('.flexible-slider-window'))];
  flexibleSliderWindows.forEach(sliderWindow => flexibleSlidify(sliderWindow));
  // slider structure: 
  // window: .infinite-slider-window
  // slider: .infinite-slider
  // slide: .infinite-slide
  const infiniteSliderWindows = [...(document.querySelectorAll('.infinite-slider-window'))];
  infiniteSliderWindows.forEach(infiniteSliderWindow => infiniteSlidify(infiniteSliderWindow));

  // add fade-in-up effects to targeted elements('.fadeInUp')
  addFadeInUpEffects();
};