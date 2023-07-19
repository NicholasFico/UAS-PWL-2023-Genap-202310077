import React from 'react'
import { Route, Routes } from 'react-router-dom'
import Home from '../../modules/components/home/Home'
import FormIn from '../../modules/components/Auth/signin/Form'
import FormUp from '../../modules/components/Auth/signup/Form'
import MenuDetail from '../../modules/components/menu/MenuDetail'
// import Order from '../../modules/components/order/Order'

export default function BasePages() {
  return (
    <Routes>
            <Route index element={<FormIn />} />
            <Route path='home' element={<Home />} />
            <Route path='formup' element={<FormIn />} />
            <Route path='formin' element={<FormUp />} />
            <Route path='menu_detail' element={<MenuDetail />} />
            {/* <Route path='order' element={<Order/>} /> */}
        </Routes>
  )
}
