import { createRouter, createWebHistory } from 'vue-router'
import EventDetailsView from '../views/EventDetailsView.vue'
import EventsView from '../views/EventsView.vue'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'events',
      component: EventsView
    },
    {
      path: '/event/:eid',
      name: 'event-details',
      component: EventDetailsView
    },
    {
      path: '/hello',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue'),
    },
  ],
})

export default router
