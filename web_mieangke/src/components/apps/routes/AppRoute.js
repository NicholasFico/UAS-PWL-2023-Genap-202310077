import React from 'react'
import { Navigate, Route, Routes } from 'react-router-dom'
import Layouts from '../../layouts/Layouts'
import Signin from '../../modules/components/Auth/signin/Signin'
import Signup from '../../modules/components/Auth/signup/Signup'
import BasePages from './BasePages'
export default function AppRoute() {
    return (
        <Routes>
            <Route index element={<Navigate to='/signin' />} />
            <Route path="signin" element={<Signin />} />
            <Route path="signup" element={<Signup />} />
            <Route path="*" element={<Layouts> <BasePages /> </Layouts>} />
        </Routes>
    )
}